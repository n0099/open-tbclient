package d.a.j0.l.f;

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
    public final Context f49436a;

    /* renamed from: b  reason: collision with root package name */
    public final View f49437b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f49438c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f49439d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.b1.m.a f49440e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f49441f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49442g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49443h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49444i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f49436a = context;
        this.f49437b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f49438c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f49437b;
    }

    public final void b() {
        if (this.f49438c.getContent() == null || this.f49438c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f49438c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f49438c.getThread_title())) {
            this.f49442g.setText(this.f49438c.getThread_title());
            this.f49442g.setVisibility(0);
            this.f49439d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f49439d.getLayoutParams()).topMargin = l.g(this.f49436a, R.dimen.tbds20);
            this.f49439d.setMaxLines(8);
        }
        this.f49439d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f49439d.setMinimumHeight(l.g(this.f49436a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f49438c.getThread_type().contains("pic")) {
            this.f49441f.setVisibility(0);
            this.f49441f.setDefaultBgResource(R.color.transparent);
            this.f49441f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f49441f.setPlaceHolder(2);
            this.f49441f.V(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f49438c.getThread_title())) {
                this.f49439d.setVisibility(8);
            } else {
                this.f49439d.setMaxLines(2);
                this.f49439d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f49439d.setLayoutStrategy(this.f49440e);
                this.f49439d.setMinimumHeight(l.g(this.f49436a, R.dimen.tbds0));
            }
        }
        this.f49439d.setText(TbRichTextView.S(this.f49436a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f49438c.getAgree_num()));
        this.f49443h.setText(StringHelper.numFormatOverWanWithNegative(this.f49438c.getPost_num()));
    }

    public final void c() {
        this.f49443h = (TextView) this.f49437b.findViewById(R.id.comment_num);
        this.f49444i = (TextView) this.f49437b.findViewById(R.id.comment_desc);
        this.j = (TextView) this.f49437b.findViewById(R.id.praise_desc);
        this.k = (TextView) this.f49437b.findViewById(R.id.praise_num);
        this.f49442g = (TextView) this.f49437b.findViewById(R.id.thread_title);
        this.f49441f = (TbImageView) this.f49437b.findViewById(R.id.main_img);
        this.f49439d = (TbRichTextView) this.f49437b.findViewById(R.id.rich_text);
        this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f49443h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f49444i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f49442g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        d.a.j0.b1.m.a aVar = new d.a.j0.b1.m.a();
        this.f49440e = aVar;
        aVar.s(l.g(this.f49436a, R.dimen.tbds38));
        this.f49440e.v(l.g(this.f49436a, R.dimen.tbds42));
        this.f49440e.j(l.g(this.f49436a, R.dimen.tbds23));
        this.f49440e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.f49440e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.f49439d.setLayoutStrategy(this.f49440e);
        this.f49439d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }
}
