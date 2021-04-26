package d.a.i0.l.f;

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
    public final Context f48607a;

    /* renamed from: b  reason: collision with root package name */
    public final View f48608b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f48609c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f48610d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.b1.m.a f48611e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f48612f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48613g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48614h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48615i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f48607a = context;
        this.f48608b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f48609c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f48608b;
    }

    public final void b() {
        if (this.f48609c.getContent() == null || this.f48609c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f48609c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f48609c.getThread_title())) {
            this.f48613g.setText(this.f48609c.getThread_title());
            this.f48613g.setVisibility(0);
            this.f48610d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f48610d.getLayoutParams()).topMargin = l.g(this.f48607a, R.dimen.tbds20);
            this.f48610d.setMaxLines(8);
        }
        this.f48610d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f48610d.setMinimumHeight(l.g(this.f48607a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f48609c.getThread_type().contains("pic")) {
            this.f48612f.setVisibility(0);
            this.f48612f.setDefaultBgResource(R.color.transparent);
            this.f48612f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f48612f.setPlaceHolder(2);
            this.f48612f.V(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f48609c.getThread_title())) {
                this.f48610d.setVisibility(8);
            } else {
                this.f48610d.setMaxLines(2);
                this.f48610d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f48610d.setLayoutStrategy(this.f48611e);
                this.f48610d.setMinimumHeight(l.g(this.f48607a, R.dimen.tbds0));
            }
        }
        this.f48610d.setText(TbRichTextView.S(this.f48607a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f48609c.getAgree_num()));
        this.f48614h.setText(StringHelper.numFormatOverWanWithNegative(this.f48609c.getPost_num()));
    }

    public final void c() {
        this.f48614h = (TextView) this.f48608b.findViewById(R.id.comment_num);
        this.f48615i = (TextView) this.f48608b.findViewById(R.id.comment_desc);
        this.j = (TextView) this.f48608b.findViewById(R.id.praise_desc);
        this.k = (TextView) this.f48608b.findViewById(R.id.praise_num);
        this.f48613g = (TextView) this.f48608b.findViewById(R.id.thread_title);
        this.f48612f = (TbImageView) this.f48608b.findViewById(R.id.main_img);
        this.f48610d = (TbRichTextView) this.f48608b.findViewById(R.id.rich_text);
        this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f48614h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f48615i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f48613g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        d.a.i0.b1.m.a aVar = new d.a.i0.b1.m.a();
        this.f48611e = aVar;
        aVar.s(l.g(this.f48607a, R.dimen.tbds38));
        this.f48611e.v(l.g(this.f48607a, R.dimen.tbds42));
        this.f48611e.j(l.g(this.f48607a, R.dimen.tbds23));
        this.f48611e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.f48611e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.f48610d.setLayoutStrategy(this.f48611e);
        this.f48610d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }
}
