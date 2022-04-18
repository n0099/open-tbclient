package com.repackage;

import android.text.TextUtils;
import android.view.ViewStub;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
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
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class mb7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int f;
    public static final int g;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public ba8 c;
    public bb8 d;
    public MultiImageView e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755504977, "Lcom/repackage/mb7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755504977, "Lcom/repackage/mb7;");
                return;
            }
        }
        f = oi.f(TbadkApplication.getInst(), R.dimen.tbds44);
        g = oi.k(TbadkApplication.getInst()) - (f * 2);
    }

    public mb7(ViewStub viewStub, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.d = (bb8) ma8.q().k(IAdBaseAsyncController.Type.PIC_BANNER, null);
        } catch (ClassCastException e) {
            if (um4.e()) {
                throw new RuntimeException(e);
            }
        }
        this.c = this.d.i(viewStub, tbPageContext);
    }

    public final vb5 a(int i, boolean z, boolean z2, String str, int i2, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), str, Integer.valueOf(i2), str2, str3, str4})) == null) {
            vb5 vb5Var = new vb5();
            vb5Var.j = z;
            if (z) {
                return vb5Var;
            }
            vb5Var.c = i;
            vb5Var.d = z2 ? this.b : this.a;
            MultiImageView multiImageView = this.e;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.e.getCurrentUrlDragImageView().getImageView() != null) {
                float[] resizedSize = this.e.getCurrentUrlDragImageView().getImageView().getResizedSize();
                if (resizedSize.length == 2) {
                    float f2 = resizedSize[0];
                    float f3 = resizedSize[1];
                    vb5Var.e = f3;
                    if (f3 != 0.0f) {
                        vb5Var.f = f2 / f3;
                    }
                }
                vb5Var.h = oi.f(TbadkApplication.getInst(), R.dimen.tbds130);
                ImageUrlData imageUrlData = this.e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
                JSONArray jSONArray = null;
                if (imageUrlData != null) {
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (JSONException e) {
                        if (um4.e()) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                if (jSONArray != null) {
                    vb5Var.h += f * Math.min(((Integer) fd5.i(TbRichTextView.U(jSONArray, false).toString(), oi.f(TbadkApplication.getInst(), R.dimen.tbds42), g).second).intValue(), 3);
                }
                if (imageUrlData != null) {
                    vb5Var.k = imageUrlData.isBlockedPic;
                }
            }
            vb5Var.g = str;
            vb5Var.i = i2;
            vb5Var.l = str2;
            vb5Var.m = str3;
            return vb5Var;
        }
        return (vb5) invokeCommon.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d.onDestroy();
            this.c.onDestroy();
        }
    }

    public void c(MultiImageView multiImageView, boolean z, int i, boolean z2, String str, int i2, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{multiImageView, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), str, Integer.valueOf(i2), str2, str3, str4}) == null) {
            this.e = multiImageView;
            vb5 a = a(i, z2, z, str, i2, str2, str3, str4);
            d(this.d.d(a), a, z);
        }
    }

    public final void d(AdvertAppInfo advertAppInfo, vb5 vb5Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, advertAppInfo, vb5Var, z) == null) {
            this.c.a(advertAppInfo, vb5Var);
            if (advertAppInfo != null) {
                if (z) {
                    this.b = Math.max(this.b, vb5Var.c);
                } else {
                    this.a = Math.max(this.a, vb5Var.c);
                }
            }
        }
    }
}
