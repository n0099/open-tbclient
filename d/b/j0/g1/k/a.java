package d.b.j0.g1.k;

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
import d.b.i0.z0.i0;
import d.b.j0.s2.j;
import d.b.j0.s2.n;
import d.b.j0.s2.v;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f56595f = l.g(TbadkApplication.getInst(), R.dimen.tbds44);

    /* renamed from: g  reason: collision with root package name */
    public static final int f56596g = l.k(TbadkApplication.getInst()) - (f56595f * 2);

    /* renamed from: a  reason: collision with root package name */
    public int f56597a;

    /* renamed from: b  reason: collision with root package name */
    public int f56598b;

    /* renamed from: c  reason: collision with root package name */
    public n f56599c;

    /* renamed from: d  reason: collision with root package name */
    public j f56600d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f56601e;

    public a(ViewStub viewStub, TbPageContext tbPageContext) {
        j g2 = v.p().g();
        this.f56600d = g2;
        this.f56599c = g2.a(viewStub, tbPageContext);
    }

    public final d.b.i0.z0.c a(int i, boolean z, boolean z2, String str, int i2, String str2, String str3, String str4) {
        d.b.i0.z0.c cVar = new d.b.i0.z0.c();
        cVar.j = z;
        if (z) {
            return cVar;
        }
        cVar.f52413c = i;
        cVar.f52414d = z2 ? this.f56598b : this.f56597a;
        MultiImageView multiImageView = this.f56601e;
        if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f56601e.getCurrentUrlDragImageView().getImageView() != null) {
            float[] resizedSize = this.f56601e.getCurrentUrlDragImageView().getImageView().getResizedSize();
            if (resizedSize.length == 2) {
                float f2 = resizedSize[0];
                float f3 = resizedSize[1];
                cVar.f52415e = f3;
                if (f3 != 0.0f) {
                    cVar.f52416f = f2 / f3;
                }
            }
            cVar.f52418h = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
            ImageUrlData imageUrlData = this.f56601e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
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
                cVar.f52418h += f56595f * Math.min(((Integer) i0.i(TbRichTextView.S(TbadkCoreApplication.getInst(), jSONArray, false).toString(), l.g(TbadkApplication.getInst(), R.dimen.tbds42), f56596g).second).intValue(), 3);
            }
            if (imageUrlData != null) {
                cVar.k = imageUrlData.isBlockedPic;
            }
        }
        cVar.f52417g = str;
        cVar.i = i2;
        cVar.l = str2;
        cVar.m = str3;
        return cVar;
    }

    public void b() {
        this.f56600d.onDestroy();
        this.f56599c.onDestroy();
    }

    public void c(MultiImageView multiImageView, boolean z, int i, boolean z2, String str, int i2, String str2, String str3, String str4) {
        this.f56601e = multiImageView;
        d.b.i0.z0.c a2 = a(i, z2, z, str, i2, str2, str3, str4);
        d(this.f56600d.b(a2), a2, z);
    }

    public final void d(AdvertAppInfo advertAppInfo, d.b.i0.z0.c cVar, boolean z) {
        this.f56599c.a(advertAppInfo, cVar);
        if (advertAppInfo != null) {
            if (z) {
                this.f56598b = Math.max(this.f56598b, cVar.f52413c);
            } else {
                this.f56597a = Math.max(this.f56597a, cVar.f52413c);
            }
        }
    }
}
