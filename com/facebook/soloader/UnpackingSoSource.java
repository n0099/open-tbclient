package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public abstract class UnpackingSoSource extends DirectorySoSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEPS_FILE_NAME = "dso_deps";
    public static final String LOCK_FILE_NAME = "dso_lock";
    public static final String MANIFEST_FILE_NAME = "dso_manifest";
    public static final byte MANIFEST_VERSION = 1;
    public static final byte STATE_CLEAN = 1;
    public static final byte STATE_DIRTY = 0;
    public static final String STATE_FILE_NAME = "dso_state";
    public static final String TAG = "fb-UnpackingSoSource";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public String[] mAbis;
    public final Context mContext;
    @Nullable
    public String mCorruptedLib;
    public final Map<String, Object> mLibsBeingLoaded;

    public abstract Unpacker makeUnpacker() throws IOException;

    /* loaded from: classes7.dex */
    public static class Dso {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.hash = str2;
        }
    }

    /* loaded from: classes7.dex */
    public static final class DsoManifest {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dsoArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dsos = dsoArr;
        }

        public final void write(DataOutput dataOutput) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataOutput) == null) {
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
        }

        public static final DsoManifest read(DataInput dataInput) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataInput)) == null) {
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
            return (DsoManifest) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class InputDso implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dso, inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dso = dso;
            this.content = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.content.close();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class InputDsoIterator implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;

        public InputDsoIterator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class Unpacker implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;

        public Unpacker() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnpackingSoSource(Context context, File file) {
        super(file, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((File) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static void writeState(File file, byte b) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{file, Byte.valueOf(b)}) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.seek(0L);
                randomAccessFile.write(b);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } finally {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((File) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = context;
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, dsoArr) == null) {
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
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, inputDso, bArr) == null) {
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
    }

    private Object getLibraryLock(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            synchronized (this.mLibsBeingLoaded) {
                obj = this.mLibsBeingLoaded.get(str);
                if (obj == null) {
                    obj = new Object();
                    this.mLibsBeingLoaded.put(str, obj);
                }
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public synchronized void prepare(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            synchronized (this) {
                synchronized (getLibraryLock(str)) {
                    this.mCorruptedLib = str;
                    prepare(2);
                }
            }
        }
    }

    public void setSoSourceAbis(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, strArr) == null) {
            this.mAbis = strArr;
        }
    }

    public static File getSoStorePath(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            return new File(context.getApplicationInfo().dataDir + "/" + str);
        }
        return (File) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean refreshLocked(FileLocker fileLocker, int i, byte[] bArr) throws IOException {
        InterceptResult invokeLIL;
        byte b;
        Unpacker makeUnpacker;
        InputDsoIterator openDsoIterator;
        DsoManifest dsoManifest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, this, fileLocker, i, bArr)) == null) {
            File file = new File(this.soDirectory, STATE_FILE_NAME);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                b = randomAccessFile.readByte();
            } catch (EOFException unused) {
            } catch (Throwable th) {
            }
            if (b != 1) {
                Log.v(TAG, "dso store " + this.soDirectory + " regeneration interrupted: wiping clean");
                b = 0;
            }
            randomAccessFile.close();
            File file2 = new File(this.soDirectory, DEPS_FILE_NAME);
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
                        Runnable runnable = new Runnable(this, file2, bArr, dsoManifest, file, fileLocker) { // from class: com.facebook.soloader.UnpackingSoSource.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ UnpackingSoSource this$0;
                            public final /* synthetic */ byte[] val$deps;
                            public final /* synthetic */ File val$depsFileName;
                            public final /* synthetic */ FileLocker val$lock;
                            public final /* synthetic */ DsoManifest val$manifest;
                            public final /* synthetic */ File val$stateFileName;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, file2, bArr, dsoManifest, file, fileLocker};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$depsFileName = file2;
                                this.val$deps = bArr;
                                this.val$manifest = dsoManifest;
                                this.val$stateFileName = file;
                                this.val$lock = fileLocker;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    try {
                                        Log.v(UnpackingSoSource.TAG, "starting syncer worker");
                                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.val$depsFileName, "rw");
                                        randomAccessFile2.write(this.val$deps);
                                        randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                                        randomAccessFile2.close();
                                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(new File(this.this$0.soDirectory, UnpackingSoSource.MANIFEST_FILE_NAME), "rw");
                                        this.val$manifest.write(randomAccessFile3);
                                        randomAccessFile3.close();
                                        SysUtil.fsyncRecursive(this.this$0.soDirectory);
                                        UnpackingSoSource.writeState(this.val$stateFileName, (byte) 1);
                                        Log.v(UnpackingSoSource.TAG, "releasing dso store lock for " + this.this$0.soDirectory + " (from syncer thread)");
                                        this.val$lock.close();
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
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
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } else {
            return invokeLIL.booleanValue;
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[Catch: all -> 0x003a, TryCatch #6 {all -> 0x003a, blocks: (B:6:0x0035, B:15:0x0047, B:16:0x004e, B:17:0x0058, B:19:0x005e, B:44:0x00a6, B:11:0x003e, B:22:0x0066, B:24:0x006b, B:26:0x007b, B:29:0x008c, B:33:0x0093), top: B:58:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #6 {all -> 0x003a, blocks: (B:6:0x0035, B:15:0x0047, B:16:0x004e, B:17:0x0058, B:19:0x005e, B:44:0x00a6, B:11:0x003e, B:22:0x0066, B:24:0x006b, B:26:0x007b, B:29:0x008c, B:33:0x0093), top: B:58:0x0035 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void regenerate(byte b, DsoManifest dsoManifest, InputDsoIterator inputDsoIterator) throws IOException {
        DsoManifest read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Byte.valueOf(b), dsoManifest, inputDsoIterator}) == null) {
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
                } finally {
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
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public byte[] getDepsBlock() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return (byte[]) invokeV.objValue;
    }

    @Override // com.facebook.soloader.SoSource
    public String[] getSoSourceAbis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] strArr = this.mAbis;
            if (strArr == null) {
                return super.getSoSourceAbis();
            }
            return strArr;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        InterceptResult invokeLIL;
        int loadLibraryFrom;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i, threadPolicy)) == null) {
            synchronized (getLibraryLock(str)) {
                loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
            }
            return loadLibraryFrom;
        }
        return invokeLIL.intValue;
    }

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
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
}
