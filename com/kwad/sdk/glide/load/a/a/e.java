package com.kwad.sdk.glide.load.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f37784a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final a f37785b;

    /* renamed from: c  reason: collision with root package name */
    public final d f37786c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f37787d;

    /* renamed from: e  reason: collision with root package name */
    public final ContentResolver f37788e;

    /* renamed from: f  reason: collision with root package name */
    public final List<ImageHeaderParser> f37789f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(398108214, "Lcom/kwad/sdk/glide/load/a/a/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(398108214, "Lcom/kwad/sdk/glide/load/a/a/e;");
                return;
            }
        }
        f37784a = new a();
    }

    public e(List<ImageHeaderParser> list, a aVar, d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, aVar, dVar, bVar, contentResolver};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f37785b = aVar;
        this.f37786c = dVar;
        this.f37787d = bVar;
        this.f37788e = contentResolver;
        this.f37789f = list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e(List<ImageHeaderParser> list, d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this(list, f37784a, dVar, bVar, contentResolver);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, dVar, bVar, contentResolver};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], (a) objArr2[1], (d) objArr2[2], (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) objArr2[3], (ContentResolver) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    private boolean a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, file)) == null) ? this.f37785b.a(file) && 0 < this.f37785b.b(file) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Nullable
    private String c(@NonNull Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, uri)) == null) {
            Cursor a2 = this.f37786c.a(uri);
            if (a2 != null) {
                try {
                    if (a2.moveToFirst()) {
                        return a2.getString(0);
                    }
                } finally {
                    if (a2 != null) {
                        a2.close();
                    }
                }
            }
            if (a2 != null) {
                a2.close();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public int a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uri)) == null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = this.f37788e.openInputStream(uri);
                    int b2 = com.kwad.sdk.glide.load.b.b(this.f37789f, inputStream, this.f37787d);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return b2;
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException | NullPointerException e2) {
                if (Log.isLoggable(ThumbnailStreamOpener.TAG, 3)) {
                    Log.d(ThumbnailStreamOpener.TAG, "Failed to open uri: " + uri, e2);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException unused3) {
                        return -1;
                    }
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public InputStream b(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri)) == null) {
            String c2 = c(uri);
            if (TextUtils.isEmpty(c2)) {
                return null;
            }
            File a2 = this.f37785b.a(c2);
            if (a(a2)) {
                Uri fromFile = Uri.fromFile(a2);
                try {
                    return this.f37788e.openInputStream(fromFile);
                } catch (NullPointerException e2) {
                    throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + LoadErrorCode.TOKEN_NEXT + fromFile).initCause(e2));
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }
}
