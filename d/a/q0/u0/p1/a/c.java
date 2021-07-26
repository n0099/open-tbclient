package d.a.q0.u0.p1.a;

import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.adapter.ForumRuleDetailItemVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.d.k.e.n;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d.a.d.k.e.a<d.a.q0.u0.p1.c.c, ForumRuleDetailItemVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context m;
    public TbRichText n;
    public List<n> o;

    /* loaded from: classes8.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f64141e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f64142f;

        public a(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64142f = cVar;
            this.f64141e = i2;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                if (this.f64142f.o != null) {
                    n nVar = (n) this.f64142f.o.get(this.f64141e);
                    if (nVar instanceof d.a.q0.u0.p1.c.c) {
                        TbRichText V = TbRichTextView.V(this.f64142f.m, ((d.a.q0.u0.p1.c.c) nVar).c(), false);
                        ClipboardManager clipboardManager = (ClipboardManager) this.f64142f.m.getSystemService("clipboard");
                        clipboardManager.setText(V.toString());
                        if (clipboardManager.getText() != null) {
                            l.L(this.f64142f.m, R.string.forum_rules_copy_clip);
                        }
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.q0.u0.p1.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        i0(i2, view, viewGroup, cVar, forumRuleDetailItemVH);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public ForumRuleDetailItemVH Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ForumRuleDetailItemVH forumRuleDetailItemVH = new ForumRuleDetailItemVH(this.m, LayoutInflater.from(this.m).inflate(R.layout.forum_rules_item, viewGroup, false));
            this.k = forumRuleDetailItemVH;
            return forumRuleDetailItemVH;
        }
        return (ForumRuleDetailItemVH) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, d.a.q0.u0.p1.c.c cVar, ForumRuleDetailItemVH forumRuleDetailItemVH) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, forumRuleDetailItemVH})) == null) {
            if (cVar != null && this.m != null) {
                forumRuleDetailItemVH.d(cVar.b());
                if (!StringUtils.isNull(cVar.d())) {
                    z = true;
                    forumRuleDetailItemVH.f15681c.setVisibility(0);
                    forumRuleDetailItemVH.f15681c.setText(cVar.d());
                } else {
                    forumRuleDetailItemVH.f15681c.setVisibility(8);
                    z = false;
                }
                if (cVar.c() != null && !StringUtils.isNull(cVar.c().toString())) {
                    forumRuleDetailItemVH.f15682d.setVisibility(0);
                    if (!z) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) forumRuleDetailItemVH.f15682d.getLayoutParams();
                        layoutParams.topMargin = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                        forumRuleDetailItemVH.f15682d.setLayoutParams(layoutParams);
                    }
                    TbRichText V = TbRichTextView.V(this.m, cVar.c(), false);
                    this.n = V;
                    forumRuleDetailItemVH.f15682d.setText(V);
                } else {
                    forumRuleDetailItemVH.f15682d.setVisibility(8);
                }
                forumRuleDetailItemVH.f15682d.setOnLongClickListener(new a(this, i2));
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.o = list;
        }
    }
}
