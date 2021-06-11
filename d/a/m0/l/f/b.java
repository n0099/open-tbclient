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
    public final Context f53154a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53155b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f53156c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f53157d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.b1.m.a f53158e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f53159f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f53160g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f53161h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53162i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        this.f53154a = context;
        this.f53155b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f53156c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        return this.f53155b;
    }

    public final void b() {
        if (this.f53156c.getContent() == null || this.f53156c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f53156c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f53156c.getThread_title())) {
            this.f53160g.setText(this.f53156c.getThread_title());
            this.f53160g.setVisibility(0);
            this.f53157d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f53157d.getLayoutParams()).topMargin = l.g(this.f53154a, R.dimen.tbds20);
            this.f53157d.setMaxLines(8);
        }
        this.f53157d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f53157d.setMinimumHeight(l.g(this.f53154a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f53156c.getThread_type().contains("pic")) {
            this.f53159f.setVisibility(0);
            this.f53159f.setDefaultBgResource(R.color.transparent);
            this.f53159f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f53159f.setPlaceHolder(2);
            this.f53159f.U(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f53156c.getThread_title())) {
                this.f53157d.setVisibility(8);
            } else {
                this.f53157d.setMaxLines(2);
                this.f53157d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f53157d.setLayoutStrategy(this.f53158e);
                this.f53157d.setMinimumHeight(l.g(this.f53154a, R.dimen.tbds0));
            }
        }
        this.f53157d.setText(TbRichTextView.S(this.f53154a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f53156c.getAgree_num()));
        this.f53161h.setText(StringHelper.numFormatOverWanWithNegative(this.f53156c.getPost_num()));
    }

    public final void c() {
        this.f53161h = (TextView) this.f53155b.findViewById(R.id.comment_num);
        this.f53162i = (TextView) this.f53155b.findViewById(R.id.comment_desc);
        this.j = (TextView) this.f53155b.findViewById(R.id.praise_desc);
        this.k = (TextView) this.f53155b.findViewById(R.id.praise_num);
        this.f53160g = (TextView) this.f53155b.findViewById(R.id.thread_title);
        this.f53159f = (TbImageView) this.f53155b.findViewById(R.id.main_img);
        this.f53157d = (TbRichTextView) this.f53155b.findViewById(R.id.rich_text);
        this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.f53161h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
        this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f53162i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f53160g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        d.a.m0.b1.m.a aVar = new d.a.m0.b1.m.a();
        this.f53158e = aVar;
        aVar.s(l.g(this.f53154a, R.dimen.tbds38));
        this.f53158e.v(l.g(this.f53154a, R.dimen.tbds42));
        this.f53158e.j(l.g(this.f53154a, R.dimen.tbds23));
        this.f53158e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
        this.f53158e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        this.f53157d.setLayoutStrategy(this.f53158e);
        this.f53157d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
    }
}
