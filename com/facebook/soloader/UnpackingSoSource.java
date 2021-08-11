package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = str;
            this.hash = str2;
        }
    }

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.dsos = dsoArr;
        }

        public static final DsoManifest read(DataInput dataInput) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataInput)) == null) {
                if (dataInput.readByte() == 1) {
                    int readInt = dataInput.readInt();
                    if (readInt >= 0) {
                        Dso[] dsoArr = new Dso[readInt];
                        for (int i2 = 0; i2 < readInt; i2++) {
                            dsoArr[i2] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                        }
                        return new DsoManifest(dsoArr);
                    }
                    throw new RuntimeException("illegal number of shared libraries");
                }
                throw new RuntimeException("wrong dso manifest version");
            }
            return (DsoManifest) invokeL.objValue;
        }

        public final void write(DataOutput dataOutput) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dataOutput) != null) {
                return;
            }
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i2 = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i2 >= dsoArr.length) {
                    return;
                }
                dataOutput.writeUTF(dsoArr[i2].name);
                dataOutput.writeUTF(this.dsos[i2].hash);
                i2++;
            }
        }
    }

    /* loaded from: classes9.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes9.dex */
    public static abstract class InputDsoIterator implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public InputDsoIterator() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;
    }

    /* loaded from: classes9.dex */
    public static abstract class Unpacker implements Closeable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Unpacker() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                        for (int i2 = 0; !z && i2 < dsoArr.length; i2++) {
                            if (dsoArr[i2].name.equals(str)) {
                                z = true;
                            }
                        }
                        if (!z) {
                            File file = new File(this.soDirectory, str);
                            r0 = "deleting unaccounted-for file " + file;
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
            String str = "extracting DSO " + inputDso.dso.name;
            if (this.soDirectory.setWritable(true, true)) {
                File file = new File(this.soDirectory, inputDso.dso.name);
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException unused) {
                    String str2 = "error overwriting " + file + " trying to delete and start over";
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
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

    public static File getSoStorePath(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) {
            return new File(context.getApplicationInfo().dataDir + "/" + str);
        }
        return (File) invokeLL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean refreshLocked(FileLocker fileLocker, int i2, byte[] bArr) throws IOException {
        InterceptResult invokeLIL;
        byte b2;
        Unpacker makeUnpacker;
        DsoManifest dsoManifest;
        InputDsoIterator openDsoIterator;
        DsoManifest dsoManifest2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(65543, this, fileLocker, i2, bArr)) != null) {
            return invokeLIL.booleanValue;
        }
        File file = new File(this.soDirectory, STATE_FILE_NAME);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            b2 = randomAccessFile.readByte();
        } catch (EOFException unused) {
        } catch (Throwable th) {
        }
        if (b2 != 1) {
            String str = "dso store " + this.soDirectory + " regeneration interrupted: wiping clean";
            b2 = 0;
        }
        randomAccessFile.close();
        File file2 = new File(this.soDirectory, DEPS_FILE_NAME);
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            int length = (int) randomAccessFile.length();
            byte[] bArr2 = new byte[length];
            if (randomAccessFile.read(bArr2) != length) {
                b2 = 0;
            }
            if (!Arrays.equals(bArr2, bArr)) {
                b2 = 0;
            }
            try {
                if (b2 != 0 && (i2 & 2) == 0) {
                    dsoManifest2 = null;
                    randomAccessFile.close();
                    if (dsoManifest2 != null) {
                        return false;
                    }
                    Runnable runnable = new Runnable(this, file2, bArr, dsoManifest2, file, fileLocker) { // from class: com.facebook.soloader.UnpackingSoSource.1
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
                                Object[] objArr = {this, file2, bArr, dsoManifest2, file, fileLocker};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$depsFileName = file2;
                            this.val$deps = bArr;
                            this.val$manifest = dsoManifest2;
                            this.val$stateFileName = file;
                            this.val$lock = fileLocker;
                        }

                        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, INVOKE] complete} */
                        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
                        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW] complete} */
                        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                                return;
                            }
                            try {
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(this.val$depsFileName, "rw");
                                try {
                                    randomAccessFile2.write(this.val$deps);
                                    randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                                    randomAccessFile2.close();
                                    RandomAccessFile randomAccessFile3 = new RandomAccessFile(new File(this.this$0.soDirectory, UnpackingSoSource.MANIFEST_FILE_NAME), "rw");
                                    try {
                                        this.val$manifest.write(randomAccessFile3);
                                        randomAccessFile3.close();
                                        SysUtil.fsyncRecursive(this.this$0.soDirectory);
                                        UnpackingSoSource.writeState(this.val$stateFileName, (byte) 1);
                                        String str2 = "releasing dso store lock for " + this.this$0.soDirectory + " (from syncer thread)";
                                        this.val$lock.close();
                                    } finally {
                                    }
                                } catch (Throwable th2) {
                                    try {
                                        throw th2;
                                    } catch (Throwable th3) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Throwable th4) {
                                            th2.addSuppressed(th4);
                                        }
                                        throw th3;
                                    }
                                }
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                    };
                    if ((i2 & 1) != 0) {
                        new Thread(runnable, "SoSync:" + this.soDirectory.getName()).start();
                    } else {
                        runnable.run();
                    }
                    return true;
                }
                regenerate(b2, dsoManifest, openDsoIterator);
                if (openDsoIterator != null) {
                    openDsoIterator.close();
                }
                if (makeUnpacker != null) {
                    makeUnpacker.close();
                }
                dsoManifest2 = dsoManifest;
                randomAccessFile.close();
                if (dsoManifest2 != null) {
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
            writeState(file, (byte) 0);
            makeUnpacker = makeUnpacker();
            dsoManifest = makeUnpacker.getDsoManifest();
            openDsoIterator = makeUnpacker.openDsoIterator();
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[Catch: all -> 0x0034, TRY_ENTER, TryCatch #5 {all -> 0x0034, blocks: (B:6:0x002f, B:13:0x003b, B:14:0x0042, B:15:0x004c, B:17:0x0052, B:42:0x009a, B:20:0x005a, B:22:0x005f, B:24:0x006f, B:27:0x0080, B:31:0x0087), top: B:57:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052 A[Catch: all -> 0x0034, TRY_LEAVE, TryCatch #5 {all -> 0x0034, blocks: (B:6:0x002f, B:13:0x003b, B:14:0x0042, B:15:0x004c, B:17:0x0052, B:42:0x009a, B:20:0x005a, B:22:0x005f, B:24:0x006f, B:27:0x0080, B:31:0x0087), top: B:57:0x002f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void regenerate(byte b2, DsoManifest dsoManifest, InputDsoIterator inputDsoIterator) throws IOException {
        DsoManifest read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Byte.valueOf(b2), dsoManifest, inputDsoIterator}) == null) {
            String str = "regenerating DSO store " + getClass().getName();
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.soDirectory, MANIFEST_FILE_NAME), "rw");
            if (b2 == 1) {
                try {
                    try {
                        read = DsoManifest.read(randomAccessFile);
                    } catch (Exception unused) {
                    }
                    if (read == null) {
                        read = new DsoManifest(new Dso[0]);
                    }
                    deleteUnmentionedFiles(dsoManifest.dsos);
                    byte[] bArr = new byte[32768];
                    while (inputDsoIterator.hasNext()) {
                        InputDso next = inputDsoIterator.next();
                        boolean z = true;
                        for (int i2 = 0; z && i2 < read.dsos.length; i2++) {
                            if (read.dsos[i2].name.equals(next.dso.name) && read.dsos[i2].hash.equals(next.dso.hash)) {
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
                    String str2 = "Finished regenerating DSO store " + getClass().getName();
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
            String str22 = "Finished regenerating DSO store " + getClass().getName();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static void writeState(File file, byte b2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65545, null, new Object[]{file, Byte.valueOf(b2)}) != null) {
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b2);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } finally {
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
                for (int i2 = 0; i2 < dsoArr.length; i2++) {
                    obtain.writeString(dsoArr[i2].name);
                    obtain.writeString(dsoArr[i2].hash);
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
            return strArr == null ? super.getSoSourceAbis() : strArr;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        InterceptResult invokeLIL;
        int loadLibraryFrom;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, threadPolicy)) == null) {
            synchronized (getLibraryLock(str)) {
                loadLibraryFrom = loadLibraryFrom(str, i2, this.soDirectory, threadPolicy);
            }
            return loadLibraryFrom;
        }
        return invokeLIL.intValue;
    }

    public abstract Unpacker makeUnpacker() throws IOException;

    @Override // com.facebook.soloader.SoSource
    public void prepare(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SysUtil.mkdirOrThrow(this.soDirectory);
            FileLocker lock = FileLocker.lock(new File(this.soDirectory, LOCK_FILE_NAME));
            try {
                String str = "locked dso store " + this.soDirectory;
                if (refreshLocked(lock, i2, getDepsBlock())) {
                    lock = null;
                } else {
                    String str2 = "dso store is up-to-date: " + this.soDirectory;
                }
            } finally {
                if (lock != null) {
                    String str3 = "releasing dso store lock for " + this.soDirectory;
                    lock.close();
                } else {
                    String str4 = "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)";
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnpackingSoSource(Context context, File file) {
        super(file, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
