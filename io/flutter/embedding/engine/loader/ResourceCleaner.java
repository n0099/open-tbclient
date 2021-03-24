package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import java.io.File;
import java.io.FilenameFilter;
/* loaded from: classes7.dex */
public class ResourceCleaner {
    public static final long DELAY_MS = 5000;
    public static final String TAG = "ResourceCleaner";
    public final Context mContext;

    /* loaded from: classes7.dex */
    public static class CleanTask extends AsyncTask<Void, Void, Void> {
        public final File[] mFilesToDelete;

        public CleanTask(File[] fileArr) {
            this.mFilesToDelete = fileArr;
        }

        private void deleteRecursively(File file) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    deleteRecursively(file2);
                }
            }
            file.delete();
        }

        public boolean hasFilesToDelete() {
            File[] fileArr = this.mFilesToDelete;
            return fileArr != null && fileArr.length > 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
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
    }

    public ResourceCleaner(Context context) {
        this.mContext = context;
    }

    public void start() {
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            return;
        }
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
