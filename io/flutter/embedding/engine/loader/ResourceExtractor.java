package io.flutter.embedding.engine.loader;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
/* loaded from: classes7.dex */
public class ResourceExtractor {
    public static final String[] SUPPORTED_ABIS = getSupportedAbis();
    public static final String TAG = "ResourceExtractor";
    public static final String TIMESTAMP_PREFIX = "res_timestamp-";
    @NonNull
    public final AssetManager mAssetManager;
    @NonNull
    public final String mDataDirPath;
    public ExtractTask mExtractTask;
    @NonNull
    public final PackageManager mPackageManager;
    @NonNull
    public final String mPackageName;
    @NonNull
    public final HashSet<String> mResources = new HashSet<>();

    /* loaded from: classes7.dex */
    public static class ExtractTask extends AsyncTask<Void, Void, Void> {
        @NonNull
        public final AssetManager mAssetManager;
        @NonNull
        public final String mDataDirPath;
        @NonNull
        public final PackageManager mPackageManager;
        @NonNull
        public final String mPackageName;
        @NonNull
        public final HashSet<String> mResources;

        public ExtractTask(@NonNull String str, @NonNull HashSet<String> hashSet, @NonNull String str2, @NonNull PackageManager packageManager, @NonNull AssetManager assetManager) {
            this.mDataDirPath = str;
            this.mResources = hashSet;
            this.mAssetManager = assetManager;
            this.mPackageName = str2;
            this.mPackageManager = packageManager;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @WorkerThread
        private boolean extractAPK(@NonNull File file) {
            Iterator<String> it = this.mResources.iterator();
            while (it.hasNext()) {
                String next = it.next();
                try {
                    String str = "assets/" + next;
                    File file2 = new File(file, next);
                    if (!file2.exists()) {
                        if (file2.getParentFile() != null) {
                            file2.getParentFile().mkdirs();
                        }
                        InputStream open = this.mAssetManager.open(next);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            ResourceExtractor.copy(open, fileOutputStream);
                            fileOutputStream.close();
                            if (open != null) {
                                open.close();
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                                break;
                            } catch (Throwable th2) {
                                if (open != null) {
                                    try {
                                        open.close();
                                    } catch (Throwable th3) {
                                        th.addSuppressed(th3);
                                    }
                                }
                                throw th2;
                                break;
                            }
                        }
                    }
                } catch (FileNotFoundException unused) {
                } catch (IOException e2) {
                    Log.w(ResourceExtractor.TAG, "Exception unpacking resources: " + e2.getMessage());
                    ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
                    return false;
                }
            }
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            File file = new File(this.mDataDirPath);
            String checkTimestamp = ResourceExtractor.checkTimestamp(file, this.mPackageManager, this.mPackageName);
            if (checkTimestamp == null) {
                return null;
            }
            ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
            if (extractAPK(file) && checkTimestamp != null) {
                try {
                    new File(file, checkTimestamp).createNewFile();
                } catch (IOException unused) {
                    Log.w(ResourceExtractor.TAG, "Failed to write resource timestamp");
                }
            }
            return null;
        }
    }

    public ResourceExtractor(@NonNull String str, @NonNull String str2, @NonNull PackageManager packageManager, @NonNull AssetManager assetManager) {
        this.mDataDirPath = str;
        this.mPackageName = str2;
        this.mPackageManager = packageManager;
        this.mAssetManager = assetManager;
    }

    public static String checkTimestamp(@NonNull File file, @NonNull PackageManager packageManager, @NonNull String str) {
        PackageInfo packageInfo;
        try {
            if (packageManager.getPackageInfo(str, 0) == null) {
                return TIMESTAMP_PREFIX;
            }
            String str2 = TIMESTAMP_PREFIX + getVersionCode(packageInfo) + "-" + packageInfo.lastUpdateTime;
            String[] existingTimestamps = getExistingTimestamps(file);
            if (existingTimestamps == null) {
                return str2;
            }
            int length = existingTimestamps.length;
            if (existingTimestamps.length == 1 && str2.equals(existingTimestamps[0])) {
                return null;
            }
            return str2;
        } catch (PackageManager.NameNotFoundException unused) {
            return TIMESTAMP_PREFIX;
        }
    }

    public static void copy(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void deleteFiles(@NonNull String str, @NonNull HashSet<String> hashSet) {
        File file = new File(str);
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            File file2 = new File(file, it.next());
            if (file2.exists()) {
                file2.delete();
            }
        }
        String[] existingTimestamps = getExistingTimestamps(file);
        if (existingTimestamps == null) {
            return;
        }
        for (String str2 : existingTimestamps) {
            new File(file, str2).delete();
        }
    }

    public static String[] getExistingTimestamps(File file) {
        return file.list(new FilenameFilter() { // from class: io.flutter.embedding.engine.loader.ResourceExtractor.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.startsWith(ResourceExtractor.TIMESTAMP_PREFIX);
            }
        });
    }

    public static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(Build.CPU_ABI, Build.CPU_ABI2));
        arrayList.removeAll(Arrays.asList(null, ""));
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static long getVersionCode(@NonNull PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return packageInfo.versionCode;
    }

    public ResourceExtractor addResource(@NonNull String str) {
        this.mResources.add(str);
        return this;
    }

    public ResourceExtractor addResources(@NonNull Collection<String> collection) {
        this.mResources.addAll(collection);
        return this;
    }

    public ResourceExtractor start() {
        ExtractTask extractTask = new ExtractTask(this.mDataDirPath, this.mResources, this.mPackageName, this.mPackageManager, this.mAssetManager);
        this.mExtractTask = extractTask;
        extractTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    public void waitForCompletion() {
        ExtractTask extractTask = this.mExtractTask;
        if (extractTask == null) {
            return;
        }
        try {
            extractTask.get();
        } catch (InterruptedException | CancellationException | ExecutionException unused) {
            deleteFiles(this.mDataDirPath, this.mResources);
        }
    }
}
