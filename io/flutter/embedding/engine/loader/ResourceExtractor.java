package io.flutter.embedding.engine.loader;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class ResourceExtractor {
    private static final String[] SUPPORTED_ABIS = getSupportedAbis();
    private static final String TAG = "ResourceExtractor";
    private static final String TIMESTAMP_PREFIX = "res_timestamp-";
    @NonNull
    private final AssetManager mAssetManager;
    @NonNull
    private final String mDataDirPath;
    private ExtractTask mExtractTask;
    @NonNull
    private final PackageManager mPackageManager;
    @NonNull
    private final String mPackageName;
    @NonNull
    private final HashSet<String> mResources = new HashSet<>();

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [io.flutter.embedding.engine.loader.ResourceExtractor.ExtractTask.extractAPK(java.io.File):boolean] */
    static /* synthetic */ void access$100(String str, HashSet hashSet) {
        deleteFiles(str, hashSet);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [io.flutter.embedding.engine.loader.ResourceExtractor.ExtractTask.extractAPK(java.io.File):boolean] */
    static /* synthetic */ void access$200(InputStream inputStream, OutputStream outputStream) throws IOException {
        copy(inputStream, outputStream);
    }

    static long getVersionCode(@NonNull PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
    }

    /* loaded from: classes14.dex */
    private static class ExtractTask extends AsyncTask<Void, Void, Void> {
        @NonNull
        private final AssetManager mAssetManager;
        @NonNull
        private final String mDataDirPath;
        @NonNull
        private final PackageManager mPackageManager;
        @NonNull
        private final String mPackageName;
        @NonNull
        private final HashSet<String> mResources;

        ExtractTask(@NonNull String str, @NonNull HashSet<String> hashSet, @NonNull String str2, @NonNull PackageManager packageManager, @NonNull AssetManager assetManager) {
            this.mDataDirPath = str;
            this.mResources = hashSet;
            this.mAssetManager = assetManager;
            this.mPackageName = str2;
            this.mPackageManager = packageManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Void... voidArr) {
            File file = new File(this.mDataDirPath);
            String checkTimestamp = ResourceExtractor.checkTimestamp(file, this.mPackageManager, this.mPackageName);
            if (checkTimestamp != null) {
                ResourceExtractor.deleteFiles(this.mDataDirPath, this.mResources);
                if (extractAPK(file) && checkTimestamp != null) {
                    try {
                        new File(file, checkTimestamp).createNewFile();
                    } catch (IOException e) {
                        Log.w(ResourceExtractor.TAG, "Failed to write resource timestamp");
                    }
                }
            }
            return null;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
            	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
            	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
            */
        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [102=4, 105=6] */
        @androidx.annotation.WorkerThread
        private boolean extractAPK(@androidx.annotation.NonNull java.io.File r7) {
            /*
                r6 = this;
                r2 = 0
                java.util.HashSet<java.lang.String> r0 = r6.mResources
                java.util.Iterator r4 = r0.iterator()
            L7:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto Lc7
                java.lang.Object r0 = r4.next()
                java.lang.String r0 = (java.lang.String) r0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                r1.<init>()     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                java.lang.String r3 = "assets/"
                java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                java.lang.StringBuilder r1 = r1.append(r0)     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                r1.toString()     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                java.io.File r1 = new java.io.File     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                r1.<init>(r7, r0)     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                boolean r3 = r1.exists()     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                if (r3 != 0) goto L7
                java.io.File r3 = r1.getParentFile()     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                if (r3 == 0) goto L3e
                java.io.File r3 = r1.getParentFile()     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                r3.mkdirs()     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
            L3e:
                android.content.res.AssetManager r3 = r6.mAssetManager     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                java.io.InputStream r5 = r3.open(r0)     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                r0 = 0
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L69
                r3.<init>(r1)     // Catch: java.lang.Throwable -> L69
                r1 = 0
                io.flutter.embedding.engine.loader.ResourceExtractor.access$200(r5, r3)     // Catch: java.lang.Throwable -> La5
                if (r3 == 0) goto L55
                if (r2 == 0) goto L9d
                r3.close()     // Catch: java.lang.Throwable -> L64
            L55:
                if (r5 == 0) goto L7
                if (r2 == 0) goto Lb9
                r5.close()     // Catch: java.lang.Throwable -> L5d
                goto L7
            L5d:
                r1 = move-exception
                r0.addSuppressed(r1)     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                goto L7
            L62:
                r0 = move-exception
                goto L7
            L64:
                r3 = move-exception
                r1.addSuppressed(r3)     // Catch: java.lang.Throwable -> L69
                goto L55
            L69:
                r0 = move-exception
                throw r0     // Catch: java.lang.Throwable -> L6b
            L6b:
                r1 = move-exception
                r3 = r0
            L6d:
                if (r5 == 0) goto L74
                if (r3 == 0) goto Lc3
                r5.close()     // Catch: java.lang.Throwable -> Lbe
            L74:
                throw r1     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
            L75:
                r0 = move-exception
                java.lang.String r1 = "ResourceExtractor"
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Exception unpacking resources: "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r0 = r0.getMessage()
                java.lang.StringBuilder r0 = r2.append(r0)
                java.lang.String r0 = r0.toString()
                android.util.Log.w(r1, r0)
                java.lang.String r0 = r6.mDataDirPath
                java.util.HashSet<java.lang.String> r1 = r6.mResources
                io.flutter.embedding.engine.loader.ResourceExtractor.access$100(r0, r1)
                r0 = 0
            L9c:
                return r0
            L9d:
                r3.close()     // Catch: java.lang.Throwable -> L69
                goto L55
            La1:
                r0 = move-exception
                r1 = r0
                r3 = r2
                goto L6d
            La5:
                r1 = move-exception
                throw r1     // Catch: java.lang.Throwable -> La7
            La7:
                r0 = move-exception
            La8:
                if (r3 == 0) goto Laf
                if (r1 == 0) goto Lb5
                r3.close()     // Catch: java.lang.Throwable -> Lb0
            Laf:
                throw r0     // Catch: java.lang.Throwable -> L69
            Lb0:
                r3 = move-exception
                r1.addSuppressed(r3)     // Catch: java.lang.Throwable -> L69
                goto Laf
            Lb5:
                r3.close()     // Catch: java.lang.Throwable -> L69
                goto Laf
            Lb9:
                r5.close()     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                goto L7
            Lbe:
                r0 = move-exception
                r3.addSuppressed(r0)     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                goto L74
            Lc3:
                r5.close()     // Catch: java.io.FileNotFoundException -> L62 java.io.IOException -> L75
                goto L74
            Lc7:
                r0 = 1
                goto L9c
            Lc9:
                r0 = move-exception
                r1 = r2
                goto La8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.loader.ResourceExtractor.ExtractTask.extractAPK(java.io.File):boolean");
        }
    }

    ResourceExtractor(@NonNull String str, @NonNull String str2, @NonNull PackageManager packageManager, @NonNull AssetManager assetManager) {
        this.mDataDirPath = str;
        this.mPackageName = str2;
        this.mPackageManager = packageManager;
        this.mAssetManager = assetManager;
    }

    ResourceExtractor addResource(@NonNull String str) {
        this.mResources.add(str);
        return this;
    }

    ResourceExtractor addResources(@NonNull Collection<String> collection) {
        this.mResources.addAll(collection);
        return this;
    }

    ResourceExtractor start() {
        this.mExtractTask = new ExtractTask(this.mDataDirPath, this.mResources, this.mPackageName, this.mPackageManager, this.mAssetManager);
        this.mExtractTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void waitForCompletion() {
        if (this.mExtractTask != null) {
            try {
                this.mExtractTask.get();
            } catch (InterruptedException | CancellationException | ExecutionException e) {
                deleteFiles(this.mDataDirPath, this.mResources);
            }
        }
    }

    private static String[] getExistingTimestamps(File file) {
        return file.list(new FilenameFilter() { // from class: io.flutter.embedding.engine.loader.ResourceExtractor.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.startsWith(ResourceExtractor.TIMESTAMP_PREFIX);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
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
        if (existingTimestamps != null) {
            for (String str2 : existingTimestamps) {
                new File(file, str2).delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String checkTimestamp(@NonNull File file, @NonNull PackageManager packageManager, @NonNull String str) {
        PackageInfo packageInfo;
        try {
            if (packageManager.getPackageInfo(str, 0) == null) {
                return TIMESTAMP_PREFIX;
            }
            String str2 = TIMESTAMP_PREFIX + getVersionCode(packageInfo) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + packageInfo.lastUpdateTime;
            String[] existingTimestamps = getExistingTimestamps(file);
            if (existingTimestamps != null) {
                if (existingTimestamps.length == 1) {
                }
                if (existingTimestamps.length != 1 || !str2.equals(existingTimestamps[0])) {
                    return str2;
                }
                return null;
            }
            return str2;
        } catch (PackageManager.NameNotFoundException e) {
            return TIMESTAMP_PREFIX;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void copy(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static String[] getSupportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            return Build.SUPPORTED_ABIS;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(Build.CPU_ABI, Build.CPU_ABI2));
        arrayList.removeAll(Arrays.asList(null, ""));
        return (String[]) arrayList.toArray(new String[0]);
    }
}
