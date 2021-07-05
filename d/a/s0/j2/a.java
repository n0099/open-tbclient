package d.a.s0.j2;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.s0.j2.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C1546a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b extends BdAsyncTask<String, Integer, ImageUploadResult> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f62344a;

        /* renamed from: b  reason: collision with root package name */
        public c f62345b;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) ? new d.a.r0.b0.f("user_pics").j(FileHelper.getFileDireciory(this.f62344a), false) : (ImageUploadResult) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageUploadResult) == null) {
                super.onPostExecute(imageUploadResult);
                if (this.f62345b != null) {
                    int i2 = 0;
                    if (imageUploadResult != null) {
                        i2 = imageUploadResult.error_code;
                        str = imageUploadResult.error_msg;
                    } else {
                        str = "";
                    }
                    this.f62345b.a(i2, str, imageUploadResult);
                }
            }
        }

        public /* synthetic */ b(C1546a c1546a) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        void a(int i2, String str, ImageUploadResult imageUploadResult);
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

    public void a(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) || StringUtils.isNull(str)) {
            return;
        }
        b bVar = new b(null);
        bVar.f62344a = str;
        bVar.f62345b = cVar;
        bVar.execute("");
    }
}
