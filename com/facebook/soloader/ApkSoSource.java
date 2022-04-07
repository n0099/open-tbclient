package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.soloader.ExtractFromZipSoSource;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
/* loaded from: classes4.dex */
public class ApkSoSource extends ExtractFromZipSoSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte APK_SO_SOURCE_SIGNATURE_VERSION = 2;
    public static final byte LIBS_DIR_DOESNT_EXIST = 1;
    public static final byte LIBS_DIR_DONT_CARE = 0;
    public static final byte LIBS_DIR_SNAPSHOT = 2;
    public static final int PREFER_ANDROID_LIBS_DIRECTORY = 1;
    public static final String TAG = "ApkSoSource";
    public transient /* synthetic */ FieldHolder $fh;
    public final int mFlags;

    /* loaded from: classes4.dex */
    public class ApkUnpacker extends ExtractFromZipSoSource.ZipUnpacker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mFlags;
        public File mLibDir;
        public final /* synthetic */ ApkSoSource this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApkUnpacker(ApkSoSource apkSoSource, ExtractFromZipSoSource extractFromZipSoSource) throws IOException {
            super(apkSoSource, extractFromZipSoSource);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {apkSoSource, extractFromZipSoSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ExtractFromZipSoSource) objArr2[0], (UnpackingSoSource) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = apkSoSource;
            this.mLibDir = new File(apkSoSource.mContext.getApplicationInfo().nativeLibraryDir);
            this.mFlags = apkSoSource.mFlags;
        }

        @Override // com.facebook.soloader.ExtractFromZipSoSource.ZipUnpacker
        public boolean shouldExtract(ZipEntry zipEntry, String str) {
            InterceptResult invokeLL;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, zipEntry, str)) == null) {
                String name = zipEntry.getName();
                boolean z = false;
                if (str.equals(this.this$0.mCorruptedLib)) {
                    this.this$0.mCorruptedLib = null;
                    str2 = String.format("allowing consideration of corrupted lib %s", str);
                } else if ((this.mFlags & 1) == 0) {
                    str2 = "allowing consideration of " + name + ": self-extraction preferred";
                } else {
                    File file = new File(this.mLibDir, str);
                    if (!file.isFile()) {
                        str2 = String.format("allowing considering of %s: %s not in system lib dir", name, str);
                    } else {
                        long length = file.length();
                        long size = zipEntry.getSize();
                        if (length != size) {
                            str2 = String.format("allowing consideration of %s: sysdir file length is %s, but the file is %s bytes long in the APK", file, Long.valueOf(length), Long.valueOf(size));
                        } else {
                            str2 = "not allowing consideration of " + name + ": deferring to libdir";
                            Log.d(ApkSoSource.TAG, str2);
                            return z;
                        }
                    }
                }
                z = true;
                Log.d(ApkSoSource.TAG, str2);
                return z;
            }
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ApkSoSource(Context context, String str, int i) {
        this(context, new File(context.getApplicationInfo().sourceDir), str, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (File) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public byte[] getDepsBlock() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            File canonicalFile = this.mZipFileName.getCanonicalFile();
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeByte((byte) 2);
                obtain.writeString(canonicalFile.getPath());
                obtain.writeLong(canonicalFile.lastModified());
                obtain.writeInt(SysUtil.getAppVersionCode(this.mContext));
                if ((this.mFlags & 1) == 0) {
                    obtain.writeByte((byte) 0);
                    return obtain.marshall();
                }
                String str = this.mContext.getApplicationInfo().nativeLibraryDir;
                if (str == null) {
                    obtain.writeByte((byte) 1);
                    return obtain.marshall();
                }
                File canonicalFile2 = new File(str).getCanonicalFile();
                if (!canonicalFile2.exists()) {
                    obtain.writeByte((byte) 1);
                    return obtain.marshall();
                }
                obtain.writeByte((byte) 2);
                obtain.writeString(canonicalFile2.getPath());
                obtain.writeLong(canonicalFile2.lastModified());
                return obtain.marshall();
            } finally {
                obtain.recycle();
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.facebook.soloader.ExtractFromZipSoSource, com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new ApkUnpacker(this, this) : (UnpackingSoSource.Unpacker) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApkSoSource(Context context, File file, String str, int i) {
        super(context, str, file, "^lib/([^/]+)/([^/]+\\.so)$");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, file, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (File) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFlags = i;
    }
}
