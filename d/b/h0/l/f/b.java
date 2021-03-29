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
    public final Context f50279a;

    /* renamed from: b  reason: collision with root package name */
    public final View f50280b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f50281c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f50282d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.b1.m.a f50283e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f50284f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f50285g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f50286h;
    public TextView i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f50279a = context;
        this.f50280b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f50281c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f50280b;
    }

    public final void b() {
        if (this.f50281c.getContent() == null || this.f50281c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f50281c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f50281c.getThread_title())) {
            this.f50285g.setText(this.f50281c.getThread_title());
            this.f50285g.setVisibility(0);
            this.f50282d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f50282d.getLayoutParams()).topMargin = l.g(this.f50279a, R.dimen.tbds20);
            this.f50282d.setMaxLines(8);
        }
        this.f50282d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f50282d.setMinimumHeight(l.g(this.f50279a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f50281c.getThread_type().contains("pic")) {
            this.f50284f.setVisibility(0);
            this.f50284f.setDefaultBgResource(R.color.transparent);
            this.f50284f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f50284f.setPlaceHolder(2);
            this.f50284f.W(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f50281c.getThread_title())) {
                this.f50282d.setVisibility(8);
            } else {
                this.f50282d.setMaxLines(2);
                this.f50282d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f50282d.setLayoutStrategy(this.f50283e);
                this.f50282d.setMinimumHeight(l.g(this.f50279a, R.dimen.tbds0));
            }
        }
        this.f50282d.setText(TbRichTextView.Q(this.f50279a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f50281c.getAgree_num()));
        this.f50286h.setText(StringHelper.numFormatOverWanWithNegative(this.f50281c.getPost_num()));
    }

    public final void c() {
        this.f50286h = (TextView) this.f50280b.findViewById(R.id.comment_num);
        this.i = (TextView) this.f50280b.findViewById(R.id.comment_desc);
        this.j = (TextView) this.f50280b.findViewById(R.id.praise_desc);
        this.k = (TextView) this.f50280b.findViewById(R.id.praise_num);
        this.f50285g = (TextView) this.f50280b.findViewById(R.id.thread_title);
        this.f50284f = (TbImageView) this.f50280b.findViewById(R.id.main_img);
        this.f50282d = (TbRichTextView) this.f50280b.findViewById(R.id.rich_text);
        this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f50286h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f50285g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        d.b.h0.b1.m.a aVar = new d.b.h0.b1.m.a();
        this.f50283e = aVar;
        aVar.s(l.g(this.f50279a, R.dimen.tbds38));
        this.f50283e.v(l.g(this.f50279a, R.dimen.tbds42));
        this.f50283e.j(l.g(this.f50279a, R.dimen.tbds23));
        this.f50283e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.f50283e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.f50282d.setLayoutStrategy(this.f50283e);
        this.f50282d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }
}
