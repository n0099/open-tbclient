package d.b.i0.g1.k;

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
import d.b.c.e.p.l;
import d.b.h0.z0.i0;
import d.b.i0.s2.j;
import d.b.i0.s2.n;
import d.b.i0.s2.v;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f56174f = l.g(TbadkApplication.getInst(), R.dimen.tbds44);

    /* renamed from: g  reason: collision with root package name */
    public static final int f56175g = l.k(TbadkApplication.getInst()) - (f56174f * 2);

    /* renamed from: a  reason: collision with root package name */
    public int f56176a;

    /* renamed from: b  reason: collision with root package name */
    public int f56177b;

    /* renamed from: c  reason: collision with root package name */
    public n f56178c;

    /* renamed from: d  reason: collision with root package name */
    public j f56179d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f56180e;

    public a(ViewStub viewStub, TbPageContext tbPageContext) {
        j g2 = v.p().g();
        this.f56179d = g2;
        this.f56178c = g2.a(viewStub, tbPageContext);
    }

    public final d.b.h0.z0.c a(int i, boolean z, boolean z2, String str, int i2, String str2, String str3, String str4) {
        d.b.h0.z0.c cVar = new d.b.h0.z0.c();
        cVar.j = z;
        if (z) {
            return cVar;
        }
        cVar.f52077c = i;
        cVar.f52078d = z2 ? this.f56177b : this.f56176a;
        MultiImageView multiImageView = this.f56180e;
        if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f56180e.getCurrentUrlDragImageView().getImageView() != null) {
            float[] resizedSize = this.f56180e.getCurrentUrlDragImageView().getImageView().getResizedSize();
            if (resizedSize.length == 2) {
                float f2 = resizedSize[0];
                float f3 = resizedSize[1];
                cVar.f52079e = f3;
                if (f3 != 0.0f) {
                    cVar.f52080f = f2 / f3;
                }
            }
            cVar.f52082h = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
            ImageUrlData imageUrlData = this.f56180e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
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
                cVar.f52082h += f56174f * Math.min(((Integer) i0.i(TbRichTextView.S(TbadkCoreApplication.getInst(), jSONArray, false).toString(), l.g(TbadkApplication.getInst(), R.dimen.tbds42), f56175g).second).intValue(), 3);
            }
            if (imageUrlData != null) {
                cVar.k = imageUrlData.isBlockedPic;
            }
        }
        cVar.f52081g = str;
        cVar.i = i2;
        cVar.l = str2;
        cVar.m = str3;
        return cVar;
    }

    public void b() {
        this.f56179d.onDestroy();
        this.f56178c.onDestroy();
    }

    public void c(MultiImageView multiImageView, boolean z, int i, boolean z2, String str, int i2, String str2, String str3, String str4) {
        this.f56180e = multiImageView;
        d.b.h0.z0.c a2 = a(i, z2, z, str, i2, str2, str3, str4);
        d(this.f56179d.b(a2), a2, z);
    }

    public final void d(AdvertAppInfo advertAppInfo, d.b.h0.z0.c cVar, boolean z) {
        this.f56178c.a(advertAppInfo, cVar);
        if (advertAppInfo != null) {
            if (z) {
                this.f56177b = Math.max(this.f56177b, cVar.f52077c);
            } else {
                this.f56176a = Math.max(this.f56176a, cVar.f52077c);
            }
        }
    }
}
