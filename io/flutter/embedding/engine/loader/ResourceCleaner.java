package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes6.dex */
class ResourceCleaner {
    private static final long DELAY_MS = 5000;
    private static final String TAG = "ResourceCleaner";
    private final Context mContext;

    /* loaded from: classes6.dex */
    private static class CleanTask extends AsyncTask<Void, Void, Void> {
        private final File[] mFilesToDelete;

        CleanTask(File[] fileArr) {
            this.mFilesToDelete = fileArr;
        }

        boolean hasFilesToDelete() {
            return this.mFilesToDelete != null && this.mFilesToDelete.length > 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            File[] fileArr;
            for (File file : this.mFilesToDelete) {
                if (file.exists()) {
                    deleteRecursively(file);
                }
            }
            return null;
        }

        private void deleteRecursively(File file) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteRecursively(file2);
                }
            }
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResourceCleaner(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start() {
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir != null) {
            final CleanTask cleanTask = new CleanTask(cacheDir.listFiles(new FilenameFilter() { // from class: io.flutter.embedding.engine.loader.ResourceCleaner.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return str.startsWith(ResourcePaths.TEMPORARY_RESOURCE_PREFIX);
                }
            }));
            if (cleanTask.hasFilesToDelete()) {
                new Handler().postDelayed(new Runnable() { // from class: io.flutter.embedding.engine.loader.ResourceCleaner.2
                    @Override // java.lang.Runnable
                    public void run() {
                        cleanTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }
                }, 5000L);
            }
        }
    }
}
