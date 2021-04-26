package d.a.j0.g1.k;

import android.text.TextUtils;
import android.view.ViewStub;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.z0.i0;
import d.a.j0.s2.j;
import d.a.j0.s2.n;
import d.a.j0.s2.w;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f54492f = l.g(TbadkApplication.getInst(), R.dimen.tbds44);

    /* renamed from: g  reason: collision with root package name */
    public static final int f54493g = l.k(TbadkApplication.getInst()) - (f54492f * 2);

    /* renamed from: a  reason: collision with root package name */
    public int f54494a;

    /* renamed from: b  reason: collision with root package name */
    public int f54495b;

    /* renamed from: c  reason: collision with root package name */
    public n f54496c;

    /* renamed from: d  reason: collision with root package name */
    public j f54497d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f54498e;

    public a(ViewStub viewStub, TbPageContext tbPageContext) {
        j e2 = w.p().e();
        this.f54497d = e2;
        this.f54496c = e2.b(viewStub, tbPageContext);
    }

    public final d.a.i0.z0.c a(int i2, boolean z, boolean z2, String str, int i3, String str2, String str3, String str4) {
        d.a.i0.z0.c cVar = new d.a.i0.z0.c();
        cVar.j = z;
        if (z) {
            return cVar;
        }
        cVar.f50090c = i2;
        cVar.f50091d = z2 ? this.f54495b : this.f54494a;
        MultiImageView multiImageView = this.f54498e;
        if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f54498e.getCurrentUrlDragImageView().getImageView() != null) {
            float[] resizedSize = this.f54498e.getCurrentUrlDragImageView().getImageView().getResizedSize();
            if (resizedSize.length == 2) {
                float f2 = resizedSize[0];
                float f3 = resizedSize[1];
                cVar.f50092e = f3;
                if (f3 != 0.0f) {
                    cVar.f50093f = f2 / f3;
                }
            }
            cVar.f50095h = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
            ImageUrlData imageUrlData = this.f54498e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
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
                cVar.f50095h += f54492f * Math.min(((Integer) i0.i(TbRichTextView.S(TbadkCoreApplication.getInst(), jSONArray, false).toString(), l.g(TbadkApplication.getInst(), R.dimen.tbds42), f54493g).second).intValue(), 3);
            }
            if (imageUrlData != null) {
                cVar.k = imageUrlData.isBlockedPic;
            }
        }
        cVar.f50094g = str;
        cVar.f50096i = i3;
        cVar.l = str2;
        cVar.m = str3;
        return cVar;
    }

    public void b() {
        this.f54497d.onDestroy();
        this.f54496c.onDestroy();
    }

    public void c(MultiImageView multiImageView, boolean z, int i2, boolean z2, String str, int i3, String str2, String str3, String str4) {
        this.f54498e = multiImageView;
        d.a.i0.z0.c a2 = a(i2, z2, z, str, i3, str2, str3, str4);
        d(this.f54497d.a(a2), a2, z);
    }

    public final void d(AdvertAppInfo advertAppInfo, d.a.i0.z0.c cVar, boolean z) {
        this.f54496c.a(advertAppInfo, cVar);
        if (advertAppInfo != null) {
            if (z) {
                this.f54495b = Math.max(this.f54495b, cVar.f50090c);
            } else {
                this.f54494a = Math.max(this.f54494a, cVar.f50090c);
            }
        }
    }
}
