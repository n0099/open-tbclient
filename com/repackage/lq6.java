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
import com.repackage.cr4;
import com.repackage.ti8;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class lq6 extends BaseAdapter implements go6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<nn> a;
    public Context b;
    public TbPageContext c;
    public String d;
    public String e;
    public UserData f;
    public xn g;
    public int h;
    public String i;
    public HashSet<String> j;
    public boolean k;
    public eo6 l;
    public final View.OnClickListener m;
    public View.OnClickListener n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq6 a;

        public a(lq6 lq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lq6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            e eVar;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((this.a.b == null || ViewHelper.checkUpIsLogin(this.a.b)) && view2 != null) {
                    if ((view2.getTag() instanceof ah8) || (view2.getTag() instanceof e)) {
                        ah8 ah8Var = null;
                        if (view2.getTag() instanceof ah8) {
                            ah8Var = (ah8) view2.getTag();
                        } else if ((view2.getTag() instanceof e) && (textView = (eVar = (e) view2.getTag()).c) != null && (textView.getTag() instanceof ah8)) {
                            ah8Var = (ah8) eVar.c.getTag();
                        }
                        if (ah8Var != null && ah8Var.i() == 2) {
                            if (StringUtils.isNull(ah8Var.h())) {
                                return;
                            }
                            String h = ah8Var.h();
                            if ((h.contains("nohead:url") || h.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                pi.N(this.a.b, R.string.obfuscated_res_0x7f0f0322);
                                return;
                            }
                            UrlManager.getInstance().dealOneLink(this.a.c, new String[]{h});
                            ti8.b b = ti8.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", ah8Var.b(), this.a.d, this.a.e, null);
                            b.d(TiebaStatic.Params.OBJ_URL, ah8Var.h());
                            b.e();
                        } else if (ah8Var == null || ah8Var.i() != 3) {
                        } else {
                            new StatisticItem("c13442").param("forum_id", this.a.d).eventStat();
                            if (this.a.c == null || TextUtils.isEmpty(this.a.d)) {
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.a.c.getPageActivity()).createNormalConfig(ng.g(this.a.d, 0L), 1)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lq6 a;

        public b(lq6 lq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lq6Var;
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
                nn nnVar = (nn) ListUtils.getItem(this.a.a, eVar.a);
                if (nnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) nnVar;
                    this.a.g.b(view2, threadData, BdUniqueId.gen(), null, this.a.k ? eVar.a + 1 : eVar.a, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", threadData.getFid()).param("tid", threadData.getTid()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", eVar.a + 1));
                } else if (nnVar instanceof hh8) {
                    this.a.g.b(view2, (hh8) nnVar, BdUniqueId.gen(), null, eVar.a, 0L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ lq6 d;

        public c(lq6 lq6Var, f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq6Var, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = lq6Var;
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

    /* loaded from: classes6.dex */
    public class d implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;

        public d(lq6 lq6Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq6Var, cr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cr4Var;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;
        public TextView d;

        public e(lq6 lq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq6Var};
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

    /* loaded from: classes6.dex */
    public class f extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView e;
        public View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(lq6 lq6Var) {
            super(lq6Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((lq6) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView e;
        public TextView f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(lq6 lq6Var) {
            super(lq6Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((lq6) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public lq6(Context context) {
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
        this.l = new eo6();
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
                    gVar.e = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090b0a);
                    gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b0b);
                    gVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092146);
                    gVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092144);
                    view2.setTag(gVar);
                }
                m(gVar, (nn) ListUtils.getItem(this.a, i));
            } else if (getItemViewType(i) == 2) {
                if (view2 != null && (view2.getTag() instanceof f)) {
                    fVar = (f) view2.getTag();
                } else {
                    fVar = new f(this);
                    view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d0316, (ViewGroup) null, false);
                    fVar.b = view2;
                    fVar.f = view2.findViewById(R.id.obfuscated_res_0x7f092147);
                    fVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092146);
                    fVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092145);
                    fVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092144);
                    view2.setTag(fVar);
                }
                nn nnVar = (nn) ListUtils.getItem(this.a, i);
                if (nnVar instanceof ThreadData) {
                    j(fVar, (ThreadData) nnVar, i);
                    fVar.a = i;
                } else if (nnVar instanceof ah8) {
                    k(fVar, (ah8) nnVar);
                } else if (nnVar instanceof gh8) {
                    y((gh8) nnVar, fVar, i);
                } else if (nnVar instanceof hh8) {
                    fVar.a = i;
                    l(fVar, (hh8) nnVar, i);
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

    @Override // com.repackage.go6
    public eo6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (eo6) invokeV.objValue;
    }

    public final void j(f fVar, ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, fVar, threadData, i) == null) || fVar == null || threadData == null) {
            return;
        }
        fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1445));
        xn6.b(fVar.d, this.h);
        threadData.parserTitleFrsForTop();
        SpannableStringBuilder span_str = threadData.getSpan_str();
        if ((span_str == null || oi.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
            span_str = new SpannableStringBuilder(threadData.getAbstractText());
            TiePlusEventController.p(threadData.getTiePlusLinkOriginData());
        }
        fVar.c.setOnTouchListener(new bu8(span_str));
        fVar.c.setText(span_str);
        fVar.b.setOnClickListener(this.n);
        h(fVar);
    }

    public final void k(f fVar, ah8 ah8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, ah8Var) == null) {
            String o = o(ah8Var);
            fVar.c.setText(ah8Var.d());
            fVar.d.setText(o);
            xn6.b(fVar.d, this.h);
            if (ah8Var.c() != 0) {
                fVar.e.setVisibility(0);
                if (ah8Var.c() == -1) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0c6d));
                } else if (ah8Var.c() > 999) {
                    fVar.e.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f5d));
                } else {
                    TextView textView = fVar.e;
                    textView.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f5c) + ah8Var.c());
                }
                if (!StringUtils.isNull(ah8Var.d())) {
                    fVar.c.setText(ah8Var.d());
                }
            } else {
                fVar.e.setVisibility(8);
            }
            h(fVar);
            fVar.c.setTag(ah8Var);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                fVar.b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet == null || !hashSet.add(ah8Var.b())) {
                return;
            }
            ti8.b b2 = ti8.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", ah8Var.b(), this.d, this.e, null);
            b2.d(TiebaStatic.Params.OBJ_URL, ah8Var.h());
            b2.e();
        }
    }

    public final void l(f fVar, hh8 hh8Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, fVar, hh8Var, i) == null) || fVar == null || hh8Var == null || hh8Var.a() == null || this.f == null) {
            return;
        }
        fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f074e));
        xn6.b(fVar.d, this.h);
        if (this.f.getIs_manager() == 1) {
            if (hh8Var.a().audit_status.intValue() == 0 && hh8Var.a().has_forum_rule.intValue() == 0) {
                fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0751));
            } else if (hh8Var.a().audit_status.intValue() == 0) {
                fVar.c.setText(hh8Var.a().title);
            } else if (hh8Var.a().audit_status.intValue() == 1) {
                fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f074f));
            } else if (hh8Var.a().audit_status.intValue() == 2) {
                fVar.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0752));
            }
        } else {
            fVar.c.setText(hh8Var.a().title);
        }
        fVar.b.setOnClickListener(this.n);
        h(fVar);
    }

    public final void m(g gVar, nn nnVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, gVar, nnVar) == null) || gVar == null || nnVar == null) {
            return;
        }
        if (nnVar instanceof ThreadData) {
            ThreadData threadData = (ThreadData) nnVar;
            threadData.parserTitleFrsForTop();
            SpannableStringBuilder span_str = threadData.getSpan_str();
            if ((span_str == null || oi.isEmptyStringAfterTrim(span_str.toString())) && threadData.getAbstractText() != null) {
                span_str = new SpannableStringBuilder(threadData.getAbstractText());
                TiePlusEventController.p(threadData.getTiePlusLinkOriginData());
            }
            gVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1445));
            gVar.c.setOnTouchListener(new bu8(span_str));
            gVar.c.setText(span_str);
            if (StringUtils.isNull(this.i)) {
                gVar.e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                layoutParams.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.d.getLayoutParams();
                layoutParams2.setMargins((int) this.b.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.e.J(this.i, 10, false);
            }
            gVar.d.setTextColor(this.h);
            gVar.b.setOnClickListener(this.n);
            h(gVar);
        } else if (nnVar instanceof ah8) {
            ah8 ah8Var = (ah8) nnVar;
            String o = o(ah8Var);
            if (StringUtils.isNull(this.i)) {
                gVar.d.setText(o);
                gVar.d.setVisibility(0);
                gVar.c.setText(ah8Var.d());
                gVar.e.setVisibility(8);
            } else {
                gVar.d.setVisibility(8);
                gVar.e.setVisibility(0);
                TextView textView = gVar.c;
                textView.setText(o + "：" + ah8Var.d());
                gVar.e.J(this.i, 10, false);
            }
            if (ah8Var.c() != 0) {
                gVar.f.setVisibility(0);
                if (ah8Var.c() == -1) {
                    gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0c6d));
                } else if (ah8Var.c() > 999) {
                    gVar.f.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f5d));
                } else {
                    TextView textView2 = gVar.f;
                    textView2.setText(this.b.getString(R.string.obfuscated_res_0x7f0f0f5c) + ah8Var.c());
                }
                if (!StringUtils.isNull(ah8Var.d())) {
                    gVar.c.setText(ah8Var.d());
                }
            } else {
                gVar.f.setVisibility(8);
            }
            gVar.d.setTextColor(this.h);
            h(gVar);
            gVar.c.setTag(ah8Var);
            View.OnClickListener onClickListener = this.m;
            if (onClickListener != null) {
                gVar.b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.j;
            if (hashSet == null || !hashSet.add(ah8Var.b())) {
                return;
            }
            ti8.b b2 = ti8.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", ah8Var.b(), this.d, this.e, null);
            b2.d(TiebaStatic.Params.OBJ_URL, ah8Var.h());
            b2.e();
        }
    }

    public List<nn> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public final String o(ah8 ah8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, ah8Var)) == null) {
            if (!TextUtils.isEmpty(ah8Var.g()) && ah8Var.g().trim().length() != 0) {
                return ah8Var.g();
            }
            if (ah8Var.a() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f13e2);
            }
            return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1446);
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

    public void r(List<nn> list) {
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

    public void v(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, xnVar) == null) {
            this.g = xnVar;
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
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || oi.isEmpty(str) || oi.isEmpty(str2)) {
            return;
        }
        cr4 cr4Var = new cr4((BaseFragmentActivity) this.b);
        cr4Var.setTitle(str2);
        cr4Var.setTitleShowCenter(true);
        cr4Var.setMessage(str);
        cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f073d, new d(this, cr4Var));
        cr4Var.create(p()).show();
    }

    public final boolean y(gh8 gh8Var, f fVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, gh8Var, fVar, i)) == null) {
            if (i != 0 || gh8Var == null || gh8Var.a() == null) {
                return false;
            }
            ForumData a2 = gh8Var.a();
            boolean z = gh8Var.b() && !ListUtils.isEmpty(a2.getTipInfos());
            String riskTipNotice = z ? a2.getTipInfos().get(0).tip_notice : a2.getRiskTipNotice();
            String riskTipPopTitle = z ? a2.getTipInfos().get(0).tip_pop_title : a2.getRiskTipPopTitle();
            String riskTipPop = z ? a2.getTipInfos().get(0).tip_pop : a2.getRiskTipPop();
            if (StringUtils.isNull(riskTipNotice)) {
                return false;
            }
            fVar.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ff0));
            xn6.b(fVar.d, this.h);
            fVar.c.setText(riskTipNotice);
            fVar.c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}
