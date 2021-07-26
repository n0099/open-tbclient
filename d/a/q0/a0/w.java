package d.a.q0.a0;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class w extends b<b2> implements d.a.q0.o.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View m;
    public TbPageContext<?> n;
    public HeadImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public b2 s;
    public u t;
    public ConstrainImageGroup u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View k = k();
        k.setOnClickListener(this);
        this.n = tbPageContext;
        HeadImageView headImageView = (HeadImageView) k.findViewById(R.id.topic_icon);
        this.o = headImageView;
        headImageView.setIsRound(true);
        this.o.setDefaultResource(R.drawable.pic_head_topic);
        this.p = (TextView) k.findViewById(R.id.card_topic_name);
        this.r = (TextView) k.findViewById(R.id.card_thread_title);
        this.q = (TextView) k.findViewById(R.id.card_reply_time);
        this.u = (ConstrainImageGroup) k.findViewById(R.id.card_img_layout);
        this.m = k.findViewById(R.id.card_divider_line);
        this.u.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        d.a.p0.d1.j.f fVar = new d.a.p0.d1.j.f(3);
        fVar.d(1.0d);
        this.u.setImageProcessor(fVar);
        this.u.setSinglePicUseStyleV10(true);
        this.u.setFromCDN(true);
        this.u.setClickable(false);
    }

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.frs_hot_topic_card_layout : invokeV.intValue;
    }

    @Override // d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.o.invalidate();
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(k(), R.drawable.addresslist_item_bg);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
            this.u.b();
            this.o.setDefaultBgResource(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.s == null) {
            return;
        }
        if (h() != null) {
            h().b(view, this.s, this.t);
        }
        if (view == k()) {
            m.a(this.s.o1());
            m.l(this.r, this.s.o1(), R.color.CAM_X0105, R.color.CAM_X0109);
            q();
        }
    }

    public final void q() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (b2Var = this.s) == null || b2Var.H() == null || this.s.H().getName_show() == null) {
            return;
        }
        long R = this.s.R();
        OriginalForumInfo originalForumInfo = this.s.F1;
        if (originalForumInfo != null) {
            R = d.a.d.e.m.b.f(originalForumInfo.id, 0L);
        }
        long j = R;
        if (d.a.p0.r0.b.h(true) && !d.a.p0.r0.b.g()) {
            String name_show = this.s.H().getName_show();
            HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(b());
            HotTopicActivityConfig createNormalConfig = hotTopicActivityConfig.createNormalConfig("", name_show + "", "3");
            createNormalConfig.setExtra(j, this.s.S(), this.s.U0(), d.a.d.e.m.b.f(this.s.o1(), 0L));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            return;
        }
        UrlManager.getInstance().dealOneLink(this.n, new String[]{this.s.t1()});
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: s */
    public void l(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, b2Var) == null) {
            if (b2Var == null) {
                if (k() != null) {
                    k().setVisibility(8);
                    return;
                }
                return;
            }
            this.s = b2Var;
            if (k() != null) {
                k().setVisibility(0);
                k().setOnClickListener(this);
            }
            if (b2Var.H() != null) {
                this.p.setText(b2Var.H().getName_show());
            }
            this.q.setText(StringHelper.getFormatTime(b2Var.r0() * 1000));
            String str = b2Var.u1() + "：";
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.append((CharSequence) b2Var.H2(false, true));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
            this.r.setText(spannableStringBuilder);
            ArrayList<MediaData> A0 = b2Var.A0();
            if (d.a.p0.s.k.c().g() && ListUtils.getCount(A0) != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < A0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(A0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        arrayList.add(mediaData);
                    }
                }
                if (ListUtils.getCount(arrayList) > 0) {
                    this.u.setVisibility(0);
                    this.u.setImageMediaList(arrayList);
                } else {
                    this.u.setVisibility(8);
                }
            } else {
                this.u.setVisibility(8);
            }
            m.l(this.r, this.s.o1(), R.color.CAM_X0105, R.color.CAM_X0109);
            m(this.n, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // d.a.q0.o.e
    public void setPage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    public void t(d.a.d.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (constrainImageGroup = this.u) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void u(d.a.d.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) || (constrainImageGroup = this.u) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }
}
