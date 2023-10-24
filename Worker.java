public class Worker {
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorListener) {
        this.callback = callback;
        this.errorCallback = errorListener;
    }


    public void start() {
        for (int i = 0; i < 100; i++) {

            if (i != 33) {
                callback.onDone("Task " + i + " is done");
            } else {
                errorCallback.onError("Task " + i + " is not done");
                // System.out.println("Task " + i +" is not done");
            }
        }
    }


    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String message);
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
}
