package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class n45<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<b<T>> a;
    public d b;
    public String c;
    public n45<T>.c d;
    public T e;
    public final ImageUploader f;
    public int g;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface b<T> {
        void a(int i, T t);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(String str, ImageUploadResult imageUploadResult);
    }

    public n45(String str, String str2) {
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.c = str;
        this.f = new ImageUploader(str2);
    }

    public T f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (T) invokeV.objValue;
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.d == null) {
            n45<T>.c cVar = new c(this, null);
            this.d = cVar;
            cVar.e(z);
            this.d.f(this.g);
            this.d.execute(new String[0]);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f.setGroupId(str);
        }
    }

    public void i(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            this.e = t;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LocalViewSize.ImageSize msgSPicMaxSize = LocalViewSize.getInstance().getMsgSPicMaxSize();
            LocalViewSize.ImageSize msgBPicMaxSize = LocalViewSize.getInstance().getMsgBPicMaxSize();
            k(msgBPicMaxSize.width, msgBPicMaxSize.height, msgSPicMaxSize.width, msgSPicMaxSize.height);
        }
    }

    public void k(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            this.f.setServersideResize(i, i2, i3, i4);
        }
    }

    public void l(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void m(b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.a = new WeakReference<>(bVar);
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.g = i;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<String, Integer, ImageUploadResult> implements ImageUploader.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public int b;
        public final /* synthetic */ n45 c;

        public c(n45 n45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n45Var;
            this.a = false;
        }

        @Override // com.baidu.tbadk.img.ImageUploader.a
        public void a(String str, Object obj, long j, long j2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, obj, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (j2 == 0) {
                    i = 0;
                } else {
                    i = (int) ((((float) j) * 100.0f) / ((float) j2));
                    if (i > 100) {
                        i = 90;
                    }
                }
                publishProgress(Integer.valueOf(i));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) ? g() : (ImageUploadResult) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imageUploadResult) == null) {
                super.onPostExecute(imageUploadResult);
                this.c.d = null;
                if (this.c.b != null) {
                    if (imageUploadResult == null) {
                        imageUploadResult = new ImageUploadResult();
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_ERROR;
                        imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f110e);
                    }
                    this.c.b.a(this.c.c, imageUploadResult);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.cancel();
                this.c.d = null;
                this.c.f.cancel();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(Integer... numArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, numArr) == null) || numArr == null || numArr.length == 0 || this.c.a == null || this.c.a.get() == null) {
                return;
            }
            ((b) this.c.a.get()).a(numArr[0].intValue(), this.c.e);
        }

        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
                this.a = z;
            }
        }

        public void f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.b = i;
            }
        }

        public final ImageUploadResult g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                this.c.f.setImageUploadProgressCallback(this, null);
                this.c.f.setWaterMaskType(this.b);
                ImageUploadResult uploadInBackground = this.c.f.uploadInBackground(this.c.c, this.a);
                publishProgress(100);
                return uploadInBackground;
            }
            return (ImageUploadResult) invokeV.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                super.onPreCancel();
                if (this.c.b != null) {
                    ImageUploadResult imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_SEND_CALCELLED;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f110e);
                    this.c.b.a(this.c.c, imageUploadResult);
                }
            }
        }

        public /* synthetic */ c(n45 n45Var, a aVar) {
            this(n45Var);
        }
    }
}
