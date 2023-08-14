package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public abstract class UnpackingSoSource extends DirectorySoSource {
    public static final String DEPS_FILE_NAME = "dso_deps";
    public static final String LOCK_FILE_NAME = "dso_lock";
    public static final String MANIFEST_FILE_NAME = "dso_manifest";
    public static final byte MANIFEST_VERSION = 1;
    public static final byte STATE_CLEAN = 1;
    public static final byte STATE_DIRTY = 0;
    public static final String STATE_FILE_NAME = "dso_state";
    public static final String TAG = "fb-UnpackingSoSource";
    @Nullable
    public String[] mAbis;
    public final Context mContext;
    @Nullable
    public String mCorruptedLib;
    public final Map<String, Object> mLibsBeingLoaded;

    /* loaded from: classes9.dex */
    public static abstract class InputDsoIterator implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;
    }

    /* loaded from: classes9.dex */
    public static abstract class Unpacker implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;
    }

    public abstract Unpacker makeUnpacker() throws IOException;

    /* loaded from: classes9.dex */
    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    /* loaded from: classes9.dex */
    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i < dsoArr.length) {
                    dataOutput.writeUTF(dsoArr[i].name);
                    dataOutput.writeUTF(this.dsos[i].hash);
                    i++;
                } else {
                    return;
                }
            }
        }

        public static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }
    }

    /* loaded from: classes9.dex */
    public static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso, InputStream inputStream) {
            this.dso = dso;
            this.content = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.content.close();
        }
    }

    public UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static void writeState(File file, byte b) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = context;
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(STATE_FILE_NAME) && !str.equals(LOCK_FILE_NAME) && !str.equals(DEPS_FILE_NAME) && !str.equals(MANIFEST_FILE_NAME)) {
                    boolean z = false;
                    for (int i = 0; !z && i < dsoArr.length; i++) {
                        if (dsoArr[i].name.equals(str)) {
                            z = true;
                        }
                    }
                    if (!z) {
                        File file = new File(this.soDirectory, str);
                        Log.v(TAG, "deleting unaccounted-for file " + file);
                        SysUtil.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.soDirectory);
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        Log.i(TAG, "extracting DSO " + inputDso.dso.name);
        if (this.soDirectory.setWritable(true, true)) {
            File file = new File(this.soDirectory, inputDso.dso.name);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e) {
                Log.w(TAG, "error overwriting " + file + " trying to delete and start over", e);
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            try {
                try {
                    int available = inputDso.content.available();
                    if (available > 1) {
                        SysUtil.fallocateIfSupported(randomAccessFile.getFD(), available);
                    }
                    SysUtil.copyBytes(randomAccessFile, inputDso.content, Integer.MAX_VALUE, bArr);
                    randomAccessFile.setLength(randomAccessFile.getFilePointer());
                    if (file.setExecutable(true, false)) {
                        return;
                    }
                    throw new IOException("cannot make file executable: " + file);
                } catch (IOException e2) {
                    SysUtil.dumbDeleteRecursive(file);
                    throw e2;
                }
            } finally {
                randomAccessFile.close();
            }
        }
        throw new IOException("cannot make directory writable for us: " + this.soDirectory);
    }

    private Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    public synchronized void prepare(String str) throws IOException {
        synchronized (getLibraryLock(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean refreshLocked(final FileLocker fileLocker, int i, final byte[] bArr) throws IOException {
        byte b;
        Unpacker makeUnpacker;
        InputDsoIterator openDsoIterator;
        final DsoManifest dsoManifest;
        final File file = new File(this.soDirectory, STATE_FILE_NAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            b = randomAccessFile.readByte();
        } catch (EOFException unused) {
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
            }
        }
        if (b != 1) {
            Log.v(TAG, "dso store " + this.soDirectory + " regeneration interrupted: wiping clean");
            b = 0;
        }
        randomAccessFile.close();
        final File file2 = new File(this.soDirectory, DEPS_FILE_NAME);
        DsoManifest dsoManifest2 = null;
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            int length = (int) randomAccessFile.length();
            byte[] bArr2 = new byte[length];
            if (randomAccessFile.read(bArr2) != length) {
                Log.v(TAG, "short read of so store deps file: marking unclean");
                b = 0;
            }
            if (!Arrays.equals(bArr2, bArr)) {
                Log.v(TAG, "deps mismatch on deps store: regenerating");
                b = 0;
            }
            try {
                if (b != 0) {
                    if ((i & 2) != 0) {
                    }
                    dsoManifest = dsoManifest2;
                    randomAccessFile.close();
                    if (dsoManifest != null) {
                        return false;
                    }
                    Runnable runnable = new Runnable() { // from class: com.facebook.soloader.UnpackingSoSource.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Log.v(UnpackingSoSource.TAG, "starting syncer worker");
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                                randomAccessFile2.write(bArr);
                                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                                randomAccessFile2.close();
                                RandomAccessFile randomAccessFile3 = new RandomAccessFile(new File(UnpackingSoSource.this.soDirectory, UnpackingSoSource.MANIFEST_FILE_NAME), "rw");
                                dsoManifest.write(randomAccessFile3);
                                randomAccessFile3.close();
                                SysUtil.fsyncRecursive(UnpackingSoSource.this.soDirectory);
                                UnpackingSoSource.writeState(file, (byte) 1);
                                Log.v(UnpackingSoSource.TAG, "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                                fileLocker.close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    };
                    if ((i & 1) != 0) {
                        new Thread(runnable, "SoSync:" + this.soDirectory.getName()).start();
                    } else {
                        runnable.run();
                    }
                    return true;
                }
                regenerate(b, dsoManifest2, openDsoIterator);
                if (openDsoIterator != null) {
                    openDsoIterator.close();
                }
                if (makeUnpacker != null) {
                    makeUnpacker.close();
                }
                dsoManifest = dsoManifest2;
                randomAccessFile.close();
                if (dsoManifest != null) {
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    if (openDsoIterator != null) {
                        try {
                            openDsoIterator.close();
                        } catch (Throwable th4) {
                            th2.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
            Log.v(TAG, "so store dirty: regenerating");
            writeState(file, (byte) 0);
            makeUnpacker = makeUnpacker();
            dsoManifest2 = makeUnpacker.getDsoManifest();
            openDsoIterator = makeUnpacker.openDsoIterator();
        } catch (Throwable th5) {
            try {
                throw th5;
            } finally {
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[Catch: all -> 0x0036, TryCatch #6 {all -> 0x0036, blocks: (B:4:0x0031, B:13:0x0043, B:14:0x004a, B:15:0x0054, B:17:0x005a, B:42:0x00a2, B:9:0x003a, B:20:0x0062, B:22:0x0067, B:24:0x0077, B:27:0x0088, B:31:0x008f), top: B:53:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #6 {all -> 0x0036, blocks: (B:4:0x0031, B:13:0x0043, B:14:0x004a, B:15:0x0054, B:17:0x005a, B:42:0x00a2, B:9:0x003a, B:20:0x0062, B:22:0x0067, B:24:0x0077, B:27:0x0088, B:31:0x008f), top: B:53:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void regenerate(byte b, DsoManifest dsoManifest, InputDsoIterator inputDsoIterator) throws IOException {
        DsoManifest read;
        Log.v(TAG, "regenerating DSO store " + getClass().getName());
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.soDirectory, MANIFEST_FILE_NAME), "rw");
        if (b == 1) {
            try {
                try {
                    read = DsoManifest.read(randomAccessFile);
                } catch (Exception e) {
                    Log.i(TAG, "error reading existing DSO manifest", e);
                }
                if (read == null) {
                    read = new DsoManifest(new Dso[0]);
                }
                deleteUnmentionedFiles(dsoManifest.dsos);
                byte[] bArr = new byte[32768];
                while (inputDsoIterator.hasNext()) {
                    InputDso next = inputDsoIterator.next();
                    boolean z = true;
                    for (int i = 0; z && i < read.dsos.length; i++) {
                        if (read.dsos[i].name.equals(next.dso.name) && read.dsos[i].hash.equals(next.dso.hash)) {
                            z = false;
                        }
                    }
                    if (z) {
                        extractDso(next, bArr);
                    }
                    if (next != null) {
                        next.close();
                    }
                }
                randomAccessFile.close();
                Log.v(TAG, "Finished regenerating DSO store " + getClass().getName());
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        read = null;
        if (read == null) {
        }
        deleteUnmentionedFiles(dsoManifest.dsos);
        byte[] bArr2 = new byte[32768];
        while (inputDsoIterator.hasNext()) {
        }
        randomAccessFile.close();
        Log.v(TAG, "Finished regenerating DSO store " + getClass().getName());
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public byte[] getDepsBlock() throws IOException {
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker();
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i = 0; i < dsoArr.length; i++) {
                obtain.writeString(dsoArr[i].name);
                obtain.writeString(dsoArr[i].hash);
            }
            if (makeUnpacker != null) {
                makeUnpacker.close();
            }
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (makeUnpacker != null) {
                    try {
                        makeUnpacker.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        if (strArr == null) {
            return super.getSoSourceAbis();
        }
        return strArr;
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker lock = FileLocker.lock(new File(this.soDirectory, LOCK_FILE_NAME));
        try {
            Log.v(TAG, "locked dso store " + this.soDirectory);
            if (refreshLocked(lock, i, getDepsBlock())) {
                lock = null;
            } else {
                Log.i(TAG, "dso store is up-to-date: " + this.soDirectory);
            }
        } finally {
            if (lock != null) {
                Log.v(TAG, "releasing dso store lock for " + this.soDirectory);
                lock.close();
            } else {
                Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        }
    }
}
