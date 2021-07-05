package d.a.s0.n0.a.g;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f63667a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.s0.n0.a.b f63668b;

    /* renamed from: d.a.s0.n0.a.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1598a extends BdAsyncTask<Void, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f63669a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f63670b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f63671c;

        public C1598a(a aVar, Bitmap bitmap, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bitmap, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63671c = aVar;
            this.f63669a = bitmap;
            this.f63670b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void[] voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                File c2 = this.f63671c.c(this.f63669a, this.f63670b);
                this.f63669a.recycle();
                return c2.getAbsolutePath();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((C1598a) str);
                if (this.f63671c.f63668b != null) {
                    this.f63671c.f63668b.onCoverPathCallBack(str);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<Void, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f63672a;

        /* renamed from: b  reason: collision with root package name */
        public long f63673b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f63674c;

        public b(a aVar, String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63674c = aVar;
            this.f63672a = str;
            this.f63673b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                Bitmap bitmap = null;
                if (TextUtils.isEmpty(this.f63672a)) {
                    return null;
                }
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(this.f63672a);
                    bitmap = mediaMetadataRetriever.getFrameAtTime(this.f63673b * 1000);
                    mediaMetadataRetriever.release();
                    return bitmap;
                } catch (Exception e2) {
                    BdLog.e(e2);
                    return bitmap;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                super.onPostExecute((b) bitmap);
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                a aVar = this.f63674c;
                aVar.b(bitmap, d.a.s0.v3.c.f68590c + System.currentTimeMillis() + ".jpg");
            }
        }
    }

    public a() {
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

    public void b(Bitmap bitmap, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, bitmap, str) == null) || bitmap == null || TextUtils.isEmpty(str)) {
            return;
        }
        new C1598a(this, bitmap, str).execute(new Void[0]);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0043 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0054 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:? */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: android.graphics.Bitmap$CompressFormat */
    /* JADX WARN: Multi-variable type inference failed */
    public File c(Bitmap bitmap, String str) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, str)) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            if (bitmap == null || TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
                    bitmap.compress(compressFormat, 100, byteArrayOutputStream);
                    bufferedOutputStream.write(byteArrayOutputStream.toByteArray());
                    d.a.c.e.m.a.d(byteArrayOutputStream);
                    byteArrayOutputStream2 = compressFormat;
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    BdLog.e(e);
                    d.a.c.e.m.a.d(byteArrayOutputStream2);
                    byteArrayOutputStream2 = byteArrayOutputStream2;
                    d.a.c.e.m.a.d(bufferedOutputStream);
                    return file;
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    d.a.c.e.m.a.d(byteArrayOutputStream2);
                    d.a.c.e.m.a.d(bufferedOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
            }
            d.a.c.e.m.a.d(bufferedOutputStream);
            return file;
        }
        return (File) invokeLL.objValue;
    }

    public void d(String str, long j, d.a.s0.n0.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Long.valueOf(j), bVar}) == null) {
            this.f63668b = bVar;
            b bVar2 = new b(this, str, j);
            this.f63667a = bVar2;
            bVar2.execute(new Void[0]);
        }
    }
}
