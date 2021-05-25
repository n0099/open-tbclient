package d.a.m0.l.f;

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
import d.a.c.e.p.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f49480a;

    /* renamed from: b  reason: collision with root package name */
    public final View f49481b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f49482c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f49483d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.b1.m.a f49484e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f49485f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49486g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49487h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49488i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f49480a = context;
        this.f49481b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f49482c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f49481b;
    }

    public final void b() {
        if (this.f49482c.getContent() == null || this.f49482c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f49482c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f49482c.getThread_title())) {
            this.f49486g.setText(this.f49482c.getThread_title());
            this.f49486g.setVisibility(0);
            this.f49483d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f49483d.getLayoutParams()).topMargin = l.g(this.f49480a, R.dimen.tbds20);
            this.f49483d.setMaxLines(8);
        }
        this.f49483d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f49483d.setMinimumHeight(l.g(this.f49480a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f49482c.getThread_type().contains("pic")) {
            this.f49485f.setVisibility(0);
            this.f49485f.setDefaultBgResource(R.color.transparent);
            this.f49485f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f49485f.setPlaceHolder(2);
            this.f49485f.V(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f49482c.getThread_title())) {
                this.f49483d.setVisibility(8);
            } else {
                this.f49483d.setMaxLines(2);
                this.f49483d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f49483d.setLayoutStrategy(this.f49484e);
                this.f49483d.setMinimumHeight(l.g(this.f49480a, R.dimen.tbds0));
            }
        }
        this.f49483d.setText(TbRichTextView.S(this.f49480a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f49482c.getAgree_num()));
        this.f49487h.setText(StringHelper.numFormatOverWanWithNegative(this.f49482c.getPost_num()));
    }

    public final void c() {
        this.f49487h = (TextView) this.f49481b.findViewById(R.id.comment_num);
        this.f49488i = (TextView) this.f49481b.findViewById(R.id.comment_desc);
        this.j = (TextView) this.f49481b.findViewById(R.id.praise_desc);
        this.k = (TextView) this.f49481b.findViewById(R.id.praise_num);
        this.f49486g = (TextView) this.f49481b.findViewById(R.id.thread_title);
        this.f49485f = (TbImageView) this.f49481b.findViewById(R.id.main_img);
        this.f49483d = (TbRichTextView) this.f49481b.findViewById(R.id.rich_text);
        this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f49487h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f49488i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f49486g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        d.a.m0.b1.m.a aVar = new d.a.m0.b1.m.a();
        this.f49484e = aVar;
        aVar.s(l.g(this.f49480a, R.dimen.tbds38));
        this.f49484e.v(l.g(this.f49480a, R.dimen.tbds42));
        this.f49484e.j(l.g(this.f49480a, R.dimen.tbds23));
        this.f49484e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.f49484e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.f49483d.setLayoutStrategy(this.f49484e);
        this.f49483d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }
}
