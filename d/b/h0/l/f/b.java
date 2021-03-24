package d.b.h0.l.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f50278a;

    /* renamed from: b  reason: collision with root package name */
    public final View f50279b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f50280c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f50281d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.b1.m.a f50282e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f50283f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50284g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50285h;
    public TextView i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f50278a = context;
        this.f50279b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f50280c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f50279b;
    }

    public final void b() {
        if (this.f50280c.getContent() == null || this.f50280c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f50280c.getContent()) {
            if (contentBean2.getType() == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "0");
                    jSONObject.put("text", contentBean2.getText());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            } else if (contentBean2.getType() == 3) {
                contentBean = contentBean2;
            }
        }
        if (!TextUtils.isEmpty(this.f50280c.getThread_title())) {
            this.f50284g.setText(this.f50280c.getThread_title());
            this.f50284g.setVisibility(0);
            this.f50281d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f50281d.getLayoutParams()).topMargin = l.g(this.f50278a, R.dimen.tbds20);
            this.f50281d.setMaxLines(8);
        }
        this.f50281d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f50281d.setMinimumHeight(l.g(this.f50278a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f50280c.getThread_type().contains("pic")) {
            this.f50283f.setVisibility(0);
            this.f50283f.setDefaultBgResource(R.color.transparent);
            this.f50283f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f50283f.setPlaceHolder(2);
            this.f50283f.W(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f50280c.getThread_title())) {
                this.f50281d.setVisibility(8);
            } else {
                this.f50281d.setMaxLines(2);
                this.f50281d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f50281d.setLayoutStrategy(this.f50282e);
                this.f50281d.setMinimumHeight(l.g(this.f50278a, R.dimen.tbds0));
            }
        }
        this.f50281d.setText(TbRichTextView.Q(this.f50278a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f50280c.getAgree_num()));
        this.f50285h.setText(StringHelper.numFormatOverWanWithNegative(this.f50280c.getPost_num()));
    }

    public final void c() {
        this.f50285h = (TextView) this.f50279b.findViewById(R.id.comment_num);
        this.i = (TextView) this.f50279b.findViewById(R.id.comment_desc);
        this.j = (TextView) this.f50279b.findViewById(R.id.praise_desc);
        this.k = (TextView) this.f50279b.findViewById(R.id.praise_num);
        this.f50284g = (TextView) this.f50279b.findViewById(R.id.thread_title);
        this.f50283f = (TbImageView) this.f50279b.findViewById(R.id.main_img);
        this.f50281d = (TbRichTextView) this.f50279b.findViewById(R.id.rich_text);
        this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f50285h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f50284g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        d.b.h0.b1.m.a aVar = new d.b.h0.b1.m.a();
        this.f50282e = aVar;
        aVar.s(l.g(this.f50278a, R.dimen.tbds38));
        this.f50282e.v(l.g(this.f50278a, R.dimen.tbds42));
        this.f50282e.j(l.g(this.f50278a, R.dimen.tbds23));
        this.f50282e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.f50282e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.f50281d.setLayoutStrategy(this.f50282e);
        this.f50281d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }
}
