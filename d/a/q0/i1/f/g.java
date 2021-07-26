package d.a.q0.i1.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f58907a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity f58908b;

    /* loaded from: classes8.dex */
    public class a extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f58909a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58909a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                super.onLoaded((a) aVar, str, i2);
                if (aVar != null) {
                    g gVar = this.f58909a;
                    gVar.e(gVar.d(gVar.f58907a, aVar.n()));
                    return;
                }
                g gVar2 = this.f58909a;
                gVar2.e(gVar2.f58908b.getPageContext().getString(R.string.save_fail));
            }
        }
    }

    public g(String str, BaseActivity baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58907a = null;
        this.f58907a = str;
        this.f58908b = baseActivity;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.f58907a == null || this.f58907a.length() <= 0) {
                    e(this.f58908b.getPageContext().getString(R.string.save_fail));
                }
                d.a.d.e.l.d.h().m(this.f58907a, 10, new a(this), this.f58908b.getUniqueId());
            } catch (Exception unused) {
                e(this.f58908b.getPageContext().getString(R.string.save_fail));
            }
        }
    }

    public final String d(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
            int saveImageFileByUser = FileHelper.saveImageFileByUser(str, bArr, this.f58908b.getPageContext().getPageActivity());
            if (saveImageFileByUser != -2) {
                if (saveImageFileByUser != 0) {
                    return this.f58908b.getPageContext().getString(R.string.save_fail);
                }
                return this.f58908b.getPageContext().getString(R.string.save_image_to_album);
            }
            return FileHelper.getSdErrorString();
        }
        return (String) invokeLL.objValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f58908b.showToast(str);
        }
    }
}
