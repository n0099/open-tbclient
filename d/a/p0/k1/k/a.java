package d.a.p0.k1.k;

import android.text.TextUtils;
import android.view.ViewStub;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.z0.c;
import d.a.o0.z0.j0;
import d.a.p0.w2.n;
import d.a.p0.w2.w;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f59338f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f59339g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f59340a;

    /* renamed from: b  reason: collision with root package name */
    public int f59341b;

    /* renamed from: c  reason: collision with root package name */
    public n f59342c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.w2.b0.a f59343d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f59344e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(604925853, "Ld/a/p0/k1/k/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(604925853, "Ld/a/p0/k1/k/a;");
                return;
            }
        }
        f59338f = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        f59339g = l.k(TbadkApplication.getInst()) - (f59338f * 2);
    }

    public a(ViewStub viewStub, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.f59343d = (d.a.p0.w2.b0.a) w.o().k(IAdBaseAsyncController.Type.PIC_BANNER, null);
        } catch (ClassCastException unused) {
        }
        this.f59342c = this.f59343d.f(viewStub, tbPageContext);
    }

    public final c a(int i2, boolean z, boolean z2, String str, int i3, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4})) == null) {
            c cVar = new c();
            cVar.j = z;
            if (z) {
                return cVar;
            }
            cVar.f53628c = i2;
            cVar.f53629d = z2 ? this.f59341b : this.f59340a;
            MultiImageView multiImageView = this.f59344e;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f59344e.getCurrentUrlDragImageView().getImageView() != null) {
                float[] resizedSize = this.f59344e.getCurrentUrlDragImageView().getImageView().getResizedSize();
                if (resizedSize.length == 2) {
                    float f2 = resizedSize[0];
                    float f3 = resizedSize[1];
                    cVar.f53630e = f3;
                    if (f3 != 0.0f) {
                        cVar.f53631f = f2 / f3;
                    }
                }
                cVar.f53633h = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
                ImageUrlData imageUrlData = this.f59344e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
                JSONArray jSONArray = null;
                if (imageUrlData != null) {
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (JSONException unused) {
                    }
                }
                if (jSONArray != null) {
                    cVar.f53633h += f59338f * Math.min(((Integer) j0.i(TbRichTextView.S(TbadkCoreApplication.getInst(), jSONArray, false).toString(), l.g(TbadkApplication.getInst(), R.dimen.tbds42), f59339g).second).intValue(), 3);
                }
                if (imageUrlData != null) {
                    cVar.k = imageUrlData.isBlockedPic;
                }
            }
            cVar.f53632g = str;
            cVar.f53634i = i3;
            cVar.l = str2;
            cVar.m = str3;
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f59343d.onDestroy();
            this.f59342c.onDestroy();
        }
    }

    public void c(MultiImageView multiImageView, boolean z, int i2, boolean z2, String str, int i3, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{multiImageView, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            this.f59344e = multiImageView;
            c a2 = a(i2, z2, z, str, i3, str2, str3, str4);
            d(this.f59343d.a(a2), a2, z);
        }
    }

    public final void d(AdvertAppInfo advertAppInfo, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, advertAppInfo, cVar, z) == null) {
            this.f59342c.a(advertAppInfo, cVar);
            if (advertAppInfo != null) {
                if (z) {
                    this.f59341b = Math.max(this.f59341b, cVar.f53628c);
                } else {
                    this.f59340a = Math.max(this.f59340a, cVar.f53628c);
                }
            }
        }
    }
}
