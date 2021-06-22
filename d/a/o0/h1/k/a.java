package d.a.o0.h1.k;

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
import d.a.n0.z0.i0;
import d.a.o0.t2.k;
import d.a.o0.t2.o;
import d.a.o0.t2.x;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f59287f = l.g(TbadkApplication.getInst(), R.dimen.tbds44);

    /* renamed from: g  reason: collision with root package name */
    public static final int f59288g = l.k(TbadkApplication.getInst()) - (f59287f * 2);

    /* renamed from: a  reason: collision with root package name */
    public int f59289a;

    /* renamed from: b  reason: collision with root package name */
    public int f59290b;

    /* renamed from: c  reason: collision with root package name */
    public o f59291c;

    /* renamed from: d  reason: collision with root package name */
    public k f59292d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f59293e;

    public a(ViewStub viewStub, TbPageContext tbPageContext) {
        k e2 = x.p().e();
        this.f59292d = e2;
        this.f59291c = e2.b(viewStub, tbPageContext);
    }

    public final d.a.n0.z0.c a(int i2, boolean z, boolean z2, String str, int i3, String str2, String str3, String str4) {
        d.a.n0.z0.c cVar = new d.a.n0.z0.c();
        cVar.j = z;
        if (z) {
            return cVar;
        }
        cVar.f54766c = i2;
        cVar.f54767d = z2 ? this.f59290b : this.f59289a;
        MultiImageView multiImageView = this.f59293e;
        if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f59293e.getCurrentUrlDragImageView().getImageView() != null) {
            float[] resizedSize = this.f59293e.getCurrentUrlDragImageView().getImageView().getResizedSize();
            if (resizedSize.length == 2) {
                float f2 = resizedSize[0];
                float f3 = resizedSize[1];
                cVar.f54768e = f3;
                if (f3 != 0.0f) {
                    cVar.f54769f = f2 / f3;
                }
            }
            cVar.f54771h = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
            ImageUrlData imageUrlData = this.f59293e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
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
                cVar.f54771h += f59287f * Math.min(((Integer) i0.i(TbRichTextView.S(TbadkCoreApplication.getInst(), jSONArray, false).toString(), l.g(TbadkApplication.getInst(), R.dimen.tbds42), f59288g).second).intValue(), 3);
            }
            if (imageUrlData != null) {
                cVar.k = imageUrlData.isBlockedPic;
            }
        }
        cVar.f54770g = str;
        cVar.f54772i = i3;
        cVar.l = str2;
        cVar.m = str3;
        return cVar;
    }

    public void b() {
        this.f59292d.onDestroy();
        this.f59291c.onDestroy();
    }

    public void c(MultiImageView multiImageView, boolean z, int i2, boolean z2, String str, int i3, String str2, String str3, String str4) {
        this.f59293e = multiImageView;
        d.a.n0.z0.c a2 = a(i2, z2, z, str, i3, str2, str3, str4);
        d(this.f59292d.a(a2), a2, z);
    }

    public final void d(AdvertAppInfo advertAppInfo, d.a.n0.z0.c cVar, boolean z) {
        this.f59291c.a(advertAppInfo, cVar);
        if (advertAppInfo != null) {
            if (z) {
                this.f59290b = Math.max(this.f59290b, cVar.f54766c);
            } else {
                this.f59289a = Math.max(this.f59289a, cVar.f54766c);
            }
        }
    }
}
