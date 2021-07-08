package com.facebook.soloader;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.soloader.UnpackingSoSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
/* loaded from: classes5.dex */
public final class ExoSoSource extends UnpackingSoSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.soloader.ExoSoSource$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public final class ExoUnpacker extends UnpackingSoSource.Unpacker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final FileDso[] mDsos;
        public final /* synthetic */ ExoSoSource this$0;

        /* loaded from: classes5.dex */
        public final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int mCurrentDso;
            public final /* synthetic */ ExoUnpacker this$1;

            public FileBackedInputDsoIterator(ExoUnpacker exoUnpacker) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {exoUnpacker};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$1 = exoUnpacker;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCurrentDso < this.this$1.mDsos.length : invokeV.booleanValue;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public UnpackingSoSource.InputDso next() throws IOException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    FileDso[] fileDsoArr = this.this$1.mDsos;
                    int i2 = this.mCurrentDso;
                    this.mCurrentDso = i2 + 1;
                    FileDso fileDso = fileDsoArr[i2];
                    FileInputStream fileInputStream = new FileInputStream(fileDso.backingFile);
                    try {
                        return new UnpackingSoSource.InputDso(fileDso, fileInputStream);
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                }
                return (UnpackingSoSource.InputDso) invokeV.objValue;
            }

            public /* synthetic */ FileBackedInputDsoIterator(ExoUnpacker exoUnpacker, AnonymousClass1 anonymousClass1) {
                this(exoUnpacker);
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00ed, code lost:
            throw new java.lang.RuntimeException("illegal line in exopackage metadata: [" + r12 + com.baidu.pass.main.facesdk.utils.PreferencesUtil.RIGHT_MOUNT);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ExoUnpacker(ExoSoSource exoSoSource, UnpackingSoSource unpackingSoSource) throws IOException {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {exoSoSource, unpackingSoSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = exoSoSource;
            Context context = exoSoSource.mContext;
            File file = new File("/data/local/tmp/exopackage/" + context.getPackageName() + "/native-libs/");
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            String[] supportedAbis = SysUtil.getSupportedAbis();
            int length = supportedAbis.length;
            int i4 = 0;
            int i5 = 0;
            loop0: while (i5 < length) {
                String str = supportedAbis[i5];
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    linkedHashSet.add(str);
                    File file3 = new File(file2, "metadata.txt");
                    if (file3.isFile()) {
                        FileReader fileReader = new FileReader(file3);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    if (readLine.length() != 0) {
                                        int indexOf = readLine.indexOf(32);
                                        if (indexOf == -1) {
                                            break loop0;
                                        }
                                        String str2 = readLine.substring(i4, indexOf) + ".so";
                                        int size = arrayList.size();
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 >= size) {
                                                z = false;
                                                break;
                                            } else if (((FileDso) arrayList.get(i6)).name.equals(str2)) {
                                                z = true;
                                                break;
                                            } else {
                                                i6++;
                                            }
                                        }
                                        if (!z) {
                                            String substring = readLine.substring(indexOf + 1);
                                            arrayList.add(new FileDso(str2, substring, new File(file2, substring)));
                                        }
                                        i4 = 0;
                                    }
                                } else {
                                    bufferedReader.close();
                                    fileReader.close();
                                    break;
                                }
                            }
                        } finally {
                        }
                    } else {
                        continue;
                    }
                }
                i5++;
                i4 = 0;
            }
            unpackingSoSource.setSoSourceAbis((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
            this.mDsos = (FileDso[]) arrayList.toArray(new FileDso[arrayList.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new UnpackingSoSource.DsoManifest(this.mDsos) : (UnpackingSoSource.DsoManifest) invokeV.objValue;
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new FileBackedInputDsoIterator(this, null) : (UnpackingSoSource.InputDsoIterator) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class FileDso extends UnpackingSoSource.Dso {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final File backingFile;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileDso(String str, String str2, File file) {
            super(str, str2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.backingFile = file;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExoSoSource(Context context, String str) {
        super(context, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ExoUnpacker(this, this) : (UnpackingSoSource.Unpacker) invokeV.objValue;
    }
}
