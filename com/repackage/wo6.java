package com.repackage;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dq4;
import com.repackage.fh8;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class wo6 extends BaseAdapter implements pm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<jn> a;
    public Context b;
    public TbPageContext c;
    public String d;
    public String e;
    public UserData f;
    public tn g;
    public int h;
    public String i;
    public HashSet<String> j;
    public boolean k;
    public nm6 l;
    public final View.OnClickListener m;
    public View.OnClickListener n;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo6 a;

        public a(wo6 wo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wo6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((this.a.b == null || ViewHelper.checkUpIsLogin(this.a.b)) && view2 != null) {
                    if ((view2.getTag() instanceof mf8) || (view2.getTag() instanceof e)) {
                        mf8 mf8Var = null;
                        if (view2.getTag() instanceof mf8) {
                            mf8Var = (mf8) view2.getTag();
                        } else if ((view2.getTag() instanceof e) && (textView = (eVar = (e) view2.getTag()).c) != null && (textView.getTag() instanceof mf8)) {
                            mf8Var = (mf8) eVar.c.getTag();
                        }
                        if (mf8Var != null && mf8Var.j() == 2) {
                            if (StringUtils.isNull(mf8Var.i())) {
                                return;
                            }
                            String i = mf8Var.i();
                            if ((i.contains("nohead:url") || i.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                li.N(this.a.b, R.string.obfuscated_res_0x7f0f0320);
                                return;
                            }
                            UrlManager.getInstance().dealOneLink(this.a.c, new String[]{i});
                            fh8.b b = fh8.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", mf8Var.b(), this.a.d, this.a.e, null);
                            b.d(TiebaStatic.Params.OBJ_URL, mf8Var.i());
                            b.e();
                        } else if (mf8Var == null || mf8Var.j() != 3) {
                        } else {
                            new StatisticItem("c13442").param("forum_id", this.a.d).eventStat();
                            if (this.a.c == null || TextUtils.isEmpty(this.a.d)) {
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.c.getPageActivity()).createNormalConfig(jg.g(this.a.d, 0L), 1)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wo6 a;

        public b(wo6 wo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wo6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setPressed(false);
                if (this.a.g == null || !(view2.getTag() instanceof e) || (eVar = (e) view2.getTag()) == null) {
                    return;
                }
                jn jnVar = (jn) ListUtils.getItem(this.a.a, eVar.a);
                if (jnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) jnVar;
                    this.a.g.b(view2, threadData, BdUniqueId.gen(), null, this.a.k ? eVar.a + 1 : eVar.a, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", threadData.getFid()).param("tid", threadData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", eVar.a + 1));
                } else if (jnVar instanceof tf8) {
                    this.a.g.b(view2, (tf8) jnVar, BdUniqueId.gen(), null, eVar.a, 0L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ wo6 d;

        public c(wo6 wo6Var, f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo6Var, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = wo6Var;
            this.a = fVar;
            this.b = str;
            this.c = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.c.getLayout().getEllipsisCount(this.a.c.getLineCount() - 1) <= 0) {
                return;
            }
            this.d.x(this.b, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;

        public d(wo6 wo6Var, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo6Var, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;
        public TextView d;

        public e(wo6 wo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView e;
        public View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(wo6 wo6Var) {
            super(wo6Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((wo6) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView e;
        public TextView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(wo6 wo6Var) {
            super(wo6Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((wo6) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public wo6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.e = "";
        this.h = SkinManager.getColor(R.color.CAM_X0302);
        this.i = "";
        this.j = new HashSet<>();
        this.l = new nm6();
        this.m = new a(this);
        this.n = new b(this);
        this.b = context;
        this.c = p();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.a) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? ListUtils.getItem(this.a, i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (getItemViewType(i) == 1) {
                if (view2 != null && (view2.getTag() instanceof g)) {
                    gVar = (g) view2.getTag();
                } else {
                    gVar = new g(this);
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0317, (ViewGroup) null, false);
                    gVar.b = view2;
                    gVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b13);
                    gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b14);
                    gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920a5);
                    gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920a3);
                    view2.setTag(gVar);
                }
                m(gVar, (jn) ListUtils.getItem(this.a, i));
            } else if (getItemViewType(i) == 2) {
                if (view2 != null && (view2.getTag() instanceof f)) {
                    fVar = (f) view2.getTag();
                } else {
                    fVar = new f(this);
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0316, (ViewGroup) null, false);
                    fVar.b = view2;
                    fVar.f = view2.findViewById(R.id.obfuscated_res_0x7f0920a6);
                    fVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920a5);
                    fVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920a4);
                    fVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920a3);
                    view2.setTag(fVar);
                    fm6.e(fVar);
                }
                jn jnVar = (jn) ListUtils.getItem(this.a, i);
                if (jnVar instanceof ThreadData) {
                    j(fVar, (ThreadData) jnVar, i);
                    fVar.a = i;
                } else if (jnVar instanceof mf8) {
                    k(fVar, (mf8) jnVar);
                } else if (jnVar instanceof sf8) {
                    y((sf8) jnVar, fVar, i);
                } else if (jnVar instanceof tf8) {
                    fVar.a = i;
                    l(fVar, (tf8) jnVar, i);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null) {
            return;
        }
        SkinManager.setViewTextColor(eVar.c, (int) R.color.CAM_X0105);
    }

    @Override // com.repackage.pm6
    public nm6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (nm6) invokeV.objValue;
    }

    public final void j(f fVar, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, fVar, threadData, i) == null) || fVar == null || threadData == null) {
            return;
        }
        fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f143e));
        fm6.f(fVar.d, this.h);
        threadData.parserTitleFrsForTop();
        SpannableStringBuilder span_str = threadData.getSpan_str();
        if ((span_str == null || ki.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
            span_str = new SpannableStringBuilder(threadData.getAbstractText());
            TiePlusEventController.p(threadData.getTiePlusLinkOriginData());
        }
        fVar.c.setOnTouchListener(new ws8(span_str));
        fVar.c.setText(span_str);
        fVar.b.setOnClickListener(this.n);
        h(fVar);
    }

    public final void k(f fVar, mf8 mf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, mf8Var) == null) {
            String o = o(mf8Var);
            fVar.c.setText(mf8Var.f());
            fVar.d.setText(o);
            fm6.f(fVar.d, this.h);
            if (mf8Var.e() != 0) {
                fVar.e.setVisibility(0);
                if (mf8Var.e() == -1) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0c76));
                } else if (mf8Var.e() > 999) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f57));
                } else {
                    TextView textView = fVar.e;
                    textView.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f56) + mf8Var.e());
                }
                if (!StringUtils.isNull(mf8Var.f())) {
                    fVar.c.setText(mf8Var.f());
                }
            } else {
                fVar.e.setVisibility(8);
            }
            h(fVar);
            fVar.c.setTag(mf8Var);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                fVar.b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet == null || !hashSet.add(mf8Var.b())) {
                return;
            }
            fh8.b b2 = fh8.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", mf8Var.b(), this.d, this.e, null);
            b2.d(TiebaStatic.Params.OBJ_URL, mf8Var.i());
            b2.e();
        }
    }

    public final void l(f fVar, tf8 tf8Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, fVar, tf8Var, i) == null) || fVar == null || tf8Var == null || tf8Var.a() == null || this.f == null) {
            return;
        }
        fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f074f));
        fm6.f(fVar.d, this.h);
        if (this.f.getIs_manager() == 1) {
            if (tf8Var.a().audit_status.intValue() == 0 && tf8Var.a().has_forum_rule.intValue() == 0) {
                fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0752));
            } else if (tf8Var.a().audit_status.intValue() == 0) {
                fVar.c.setText(tf8Var.a().title);
            } else if (tf8Var.a().audit_status.intValue() == 1) {
                fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0750));
            } else if (tf8Var.a().audit_status.intValue() == 2) {
                fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0753));
            }
        } else {
            fVar.c.setText(tf8Var.a().title);
        }
        fVar.b.setOnClickListener(this.n);
        h(fVar);
    }

    public final void m(g gVar, jn jnVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, gVar, jnVar) == null) || gVar == null || jnVar == null) {
            return;
        }
        if (jnVar instanceof ThreadData) {
            ThreadData threadData = (ThreadData) jnVar;
            threadData.parserTitleFrsForTop();
            SpannableStringBuilder span_str = threadData.getSpan_str();
            if ((span_str == null || ki.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
                span_str = new SpannableStringBuilder(threadData.getAbstractText());
                TiePlusEventController.p(threadData.getTiePlusLinkOriginData());
            }
            gVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f143e));
            gVar.c.setOnTouchListener(new ws8(span_str));
            gVar.c.setText(span_str);
            if (StringUtils.isNull(this.i)) {
                gVar.e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                layoutParams.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                layoutParams2.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.e.K(this.i, 10, false);
            }
            gVar.d.setTextColor(this.h);
            gVar.b.setOnClickListener(this.n);
            h(gVar);
        } else if (jnVar instanceof mf8) {
            mf8 mf8Var = (mf8) jnVar;
            String o = o(mf8Var);
            if (StringUtils.isNull(this.i)) {
                gVar.d.setText(o);
                gVar.d.setVisibility(0);
                gVar.c.setText(mf8Var.f());
                gVar.e.setVisibility(8);
            } else {
                gVar.d.setVisibility(8);
                gVar.e.setVisibility(0);
                TextView textView = gVar.c;
                textView.setText(o + "：" + mf8Var.f());
                gVar.e.K(this.i, 10, false);
            }
            if (mf8Var.e() != 0) {
                gVar.f.setVisibility(0);
                if (mf8Var.e() == -1) {
                    gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0c76));
                } else if (mf8Var.e() > 999) {
                    gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f57));
                } else {
                    TextView textView2 = gVar.f;
                    textView2.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f56) + mf8Var.e());
                }
                if (!StringUtils.isNull(mf8Var.f())) {
                    gVar.c.setText(mf8Var.f());
                }
            } else {
                gVar.f.setVisibility(8);
            }
            gVar.d.setTextColor(this.h);
            h(gVar);
            gVar.c.setTag(mf8Var);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                gVar.b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet == null || !hashSet.add(mf8Var.b())) {
                return;
            }
            fh8.b b2 = fh8.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", mf8Var.b(), this.d, this.e, null);
            b2.d(TiebaStatic.Params.OBJ_URL, mf8Var.i());
            b2.e();
        }
    }

    public List<jn> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final String o(mf8 mf8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, mf8Var)) == null) {
            if (!TextUtils.isEmpty(mf8Var.g()) && mf8Var.g().trim().length() != 0) {
                return mf8Var.g();
            }
            if (mf8Var.a() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13dc);
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f143f);
        }
        return (String) invokeL.objValue;
    }

    public TbPageContext p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Context context = this.b;
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
        }
    }

    public void r(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    public void s(String str, String str2, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, userData) == null) {
            this.d = str;
            this.e = str2;
            this.f = userData;
        }
    }

    public void t(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, forumData) == null) {
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.i = str;
        }
    }

    public void v(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, tnVar) == null) {
            this.g = tnVar;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.h = i;
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || ki.isEmpty(str) || ki.isEmpty(str2)) {
            return;
        }
        dq4 dq4Var = new dq4((BaseFragmentActivity) this.b);
        dq4Var.setTitle(str2);
        dq4Var.setTitleShowCenter(true);
        dq4Var.setMessage(str);
        dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f073e, new d(this, dq4Var));
        dq4Var.create(p()).show();
    }

    public final boolean y(sf8 sf8Var, f fVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, sf8Var, fVar, i)) == null) {
            if (i != 0 || sf8Var == null || sf8Var.a() == null) {
                return false;
            }
            ForumData a2 = sf8Var.a();
            boolean z = sf8Var.b() && !ListUtils.isEmpty(a2.getTipInfos());
            String riskTipNotice = z ? a2.getTipInfos().get(0).tip_notice : a2.getRiskTipNotice();
            String riskTipPopTitle = z ? a2.getTipInfos().get(0).tip_pop_title : a2.getRiskTipPopTitle();
            String riskTipPop = z ? a2.getTipInfos().get(0).tip_pop : a2.getRiskTipPop();
            if (StringUtils.isNull(riskTipNotice)) {
                return false;
            }
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fee));
            fm6.f(fVar.d, this.h);
            fVar.c.setText(riskTipNotice);
            fVar.c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
