package d.a.p0.m.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f52744a;

    /* renamed from: b  reason: collision with root package name */
    public final View f52745b;

    /* renamed from: c  reason: collision with root package name */
    public final ThreadAchievementShareInfo.ParamBean f52746c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichTextView f52747d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.d1.m.a f52748e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52749f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52750g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52751h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52752i;
    public TextView j;
    public TextView k;

    public b(Context context, ThreadAchievementShareInfo threadAchievementShareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, threadAchievementShareInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52744a = context;
        this.f52745b = LayoutInflater.from(context).inflate(R.layout.normal_interaction_achievement, (ViewGroup) null);
        this.f52746c = threadAchievementShareInfo.getParams();
        c();
        b();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52745b : (View) invokeV.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f52746c.getContent() == null || this.f52746c.getContent().size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        ThreadAchievementShareInfo.ContentBean contentBean = null;
        for (ThreadAchievementShareInfo.ContentBean contentBean2 : this.f52746c.getContent()) {
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
        if (!TextUtils.isEmpty(this.f52746c.getThread_title())) {
            this.f52750g.setText(this.f52746c.getThread_title());
            this.f52750g.setVisibility(0);
            this.f52747d.setMaxLines(6);
        } else {
            ((LinearLayout.LayoutParams) this.f52747d.getLayoutParams()).topMargin = l.g(this.f52744a, R.dimen.tbds20);
            this.f52747d.setMaxLines(8);
        }
        this.f52747d.setTextEllipsize(TextUtils.TruncateAt.END);
        this.f52747d.setMinimumHeight(l.g(this.f52744a, R.dimen.tbds516));
        if (contentBean != null && !TextUtils.isEmpty(contentBean.getSrc()) && this.f52746c.getThread_type().contains("pic")) {
            this.f52749f.setVisibility(0);
            this.f52749f.setDefaultBgResource(R.color.transparent);
            this.f52749f.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.f52749f.setPlaceHolder(2);
            this.f52749f.M(contentBean.getSrc(), 10, false);
            if (!TextUtils.isEmpty(this.f52746c.getThread_title())) {
                this.f52747d.setVisibility(8);
            } else {
                this.f52747d.setMaxLines(2);
                this.f52747d.setTextEllipsize(TextUtils.TruncateAt.END);
                this.f52747d.setLayoutStrategy(this.f52748e);
                this.f52747d.setMinimumHeight(l.g(this.f52744a, R.dimen.tbds0));
            }
        }
        this.f52747d.setText(TbRichTextView.T(this.f52744a, jSONArray, false));
        this.k.setText(StringHelper.numFormatOverWanWithNegative(this.f52746c.getAgree_num()));
        this.f52751h.setText(StringHelper.numFormatOverWanWithNegative(this.f52746c.getPost_num()));
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f52751h = (TextView) this.f52745b.findViewById(R.id.comment_num);
            this.f52752i = (TextView) this.f52745b.findViewById(R.id.comment_desc);
            this.j = (TextView) this.f52745b.findViewById(R.id.praise_desc);
            this.k = (TextView) this.f52745b.findViewById(R.id.praise_num);
            this.f52750g = (TextView) this.f52745b.findViewById(R.id.thread_title);
            this.f52749f = (TbImageView) this.f52745b.findViewById(R.id.main_img);
            this.f52747d = (TbRichTextView) this.f52745b.findViewById(R.id.rich_text);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.f52751h.setTextColor(SkinManager.getColor(R.color.CAM_X0310));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f52752i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f52750g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            d.a.p0.d1.m.a aVar = new d.a.p0.d1.m.a();
            this.f52748e = aVar;
            aVar.s(l.g(this.f52744a, R.dimen.tbds38));
            this.f52748e.v(l.g(this.f52744a, R.dimen.tbds42));
            this.f52748e.j(l.g(this.f52744a, R.dimen.tbds23));
            this.f52748e.o(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12), 1.0f);
            this.f52748e.i(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
            this.f52747d.setLayoutStrategy(this.f52748e);
            this.f52747d.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        }
    }
}
