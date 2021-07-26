package d.a.q0.h;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.q.w0;
import d.a.q0.h.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public i B;
    public UserData C;
    public boolean D;
    public boolean E;
    public int F;
    public ClickableSpan G;
    public CompoundButton.OnCheckedChangeListener H;
    public PopupWindow.OnDismissListener I;
    public CustomMessageListener J;

    /* renamed from: a  reason: collision with root package name */
    public Context f57209a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57210b;

    /* renamed from: c  reason: collision with root package name */
    public w0 f57211c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f57212d;

    /* renamed from: e  reason: collision with root package name */
    public List<b.C1401b> f57213e;

    /* renamed from: f  reason: collision with root package name */
    public int f57214f;

    /* renamed from: g  reason: collision with root package name */
    public int f57215g;

    /* renamed from: h  reason: collision with root package name */
    public int f57216h;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView.b f57217i;
    public PopupWindow j;
    public View k;
    public d.a.q0.h.b l;
    public boolean m;
    public int n;
    public PopupWindow o;
    public ViewGroup p;
    public EMTextView q;
    public EMTextView r;
    public EMTextView s;
    public EMTextView t;
    public EMTextView u;
    public LinearLayout v;
    public String w;
    public g x;
    public h y;
    public d.a.p0.s.f0.a z;

    /* loaded from: classes8.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f57218e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57218e = jVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f57218e.f57217i != null) {
                    this.f57218e.f57217i.onCheckedChanged(this.f57218e.f57211c, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1401b) {
                    b.C1401b c1401b = (b.C1401b) compoundButton.getTag();
                    if (z) {
                        if (this.f57218e.f57213e.contains(c1401b)) {
                            return;
                        }
                        this.f57218e.f57213e.add(c1401b);
                        if (!this.f57218e.D || this.f57218e.r == null) {
                            return;
                        }
                        this.f57218e.r.setClickable(true);
                        d.a.p0.s.u.c.d(this.f57218e.r).t(R.color.CAM_X0302);
                        return;
                    }
                    this.f57218e.f57213e.remove(c1401b);
                    if (!this.f57218e.D || this.f57218e.r == null) {
                        return;
                    }
                    this.f57218e.r.setClickable(false);
                    this.f57218e.r.setTextColor(d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f57219e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57219e = jVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57219e.j == null) {
                return;
            }
            this.f57219e.j.dismiss();
            this.f57219e.j = null;
            MessageManager.getInstance().unRegisterListener(this.f57219e.J);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f57220a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j jVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57220a = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f57220a.s();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f57221e;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57221e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57221e.j != null) {
                    this.f57221e.j.dismiss();
                    this.f57221e.j = null;
                }
                if (this.f57221e.o != null) {
                    this.f57221e.o.dismiss();
                    this.f57221e.o = null;
                }
                if (this.f57221e.x != null) {
                    this.f57221e.x.onClick();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f57222e;

        public e(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57222e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                JSONObject u = this.f57222e.u();
                if (this.f57222e.w == "3" || this.f57222e.w == "4" || this.f57222e.w == "1") {
                    this.f57222e.t();
                } else if (u != null) {
                    this.f57222e.E();
                    CustomMessage customMessage = new CustomMessage(2016489, this.f57222e.f57210b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, u);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f57223e;

        public f(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57223e = jVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumRuleEditActivityConfig(this.f57223e.f57209a, this.f57223e.B.b(), this.f57223e.B.c(), this.f57223e.B.a(), this.f57223e.B.g(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                if (this.f57223e.j != null) {
                    this.f57223e.j.dismiss();
                    this.f57223e.j = null;
                }
                if (this.f57223e.o != null) {
                    this.f57223e.o.dismiss();
                    this.f57223e.o = null;
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0304));
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface g {
        void onClick();
    }

    /* loaded from: classes8.dex */
    public interface h {
        void a(JSONArray jSONArray);
    }

    public j(TbPageContext tbPageContext, View view, i iVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, iVar, userData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57209a = null;
        this.f57211c = null;
        this.f57212d = null;
        this.f57213e = new ArrayList();
        this.f57217i = null;
        this.o = null;
        this.z = null;
        this.A = 3;
        this.D = true;
        this.E = false;
        this.H = new a(this);
        this.I = new b(this);
        this.J = new c(this, 2001304);
        this.f57209a = tbPageContext.getPageActivity();
        this.f57210b = tbPageContext;
        this.k = view;
        this.B = iVar;
        this.C = userData;
        y();
        x();
    }

    public void A(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, w0Var) == null) || w0Var == null) {
            return;
        }
        this.f57211c = w0Var;
        SparseArray<String> b2 = w0Var.b();
        this.f57212d = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f57212d.size() - 1; size >= 8; size--) {
                this.f57212d.removeAt(size);
            }
        }
        this.l.j(w0Var);
    }

    public void B(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr) == null) {
            this.l.k(strArr);
        }
    }

    public void C(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.y = hVar;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f57209a == null) {
            return;
        }
        this.w = str;
        View v = v();
        if (v != null && v.getParent() != null) {
            ((ViewGroup) v.getParent()).removeView(v);
        }
        if (v == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(l.g(this.f57209a, R.dimen.tbds31));
        v.setBackgroundDrawable(gradientDrawable);
        s();
        this.f57214f = w();
        PopupWindow popupWindow = new PopupWindow(v, this.f57215g, this.f57214f);
        this.o = popupWindow;
        popupWindow.setFocusable(true);
        this.o.setTouchable(true);
        this.o.setOnDismissListener(this.I);
        z();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f57209a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.j = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.j.showAtLocation(this.k, 0, 0, 0);
        this.o.showAtLocation(this.k, 17, 0, 0);
        NEGFeedBackView.b bVar = this.f57217i;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f57211c);
        }
        this.m = true;
        MessageManager.getInstance().registerListener(this.J);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.z == null) {
                this.z = new d.a.p0.s.f0.a(this.f57210b);
            }
            this.z.i(R.string.loading);
            this.z.h(true);
        }
    }

    public final void s() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.A) {
            return;
        }
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColorSelector(this.q, R.color.CAM_X0105);
        if (this.D) {
            this.r.setTextColor(d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0302), SkinManager.RESOURCE_ALPHA_DISABLE));
            this.r.setClickable(false);
        } else {
            d.a.p0.s.u.c.d(this.r).t(R.color.CAM_X0302);
        }
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0109, 1);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105, 1);
        this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0205));
        gradientDrawable.setCornerRadius(l.g(this.f57209a, R.dimen.tbds31));
        this.p.setBackgroundDrawable(gradientDrawable);
        this.A = skinType;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PopupWindow popupWindow = this.o;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.o = null;
            }
            PopupWindow popupWindow2 = this.j;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.j = null;
            }
        }
    }

    public final JSONObject u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f57211c == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.f57213e)) {
                int i3 = 0;
                while (i2 < this.f57213e.size()) {
                    b.C1401b c1401b = this.f57213e.get(i2);
                    if (c1401b != null) {
                        jSONArray.put(String.valueOf(c1401b.f57145b));
                        i3 = c1401b.f57144a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.w).param("obj_type", i2));
            h hVar = this.y;
            if (hVar != null) {
                hVar.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.f57211c.f());
                jSONObject.put("type", this.f57211c.a());
                jSONObject.put("forum_id", this.f57211c.c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Context context = this.f57209a;
            if (context == null) {
                return null;
            }
            if (this.p == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ueg_new_delete_thread_view, (ViewGroup) null);
                this.p = viewGroup;
                EMTextView eMTextView = (EMTextView) viewGroup.findViewById(R.id.ueg_new_delete_thread_title_view);
                this.s = eMTextView;
                d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(eMTextView);
                d2.y(R.string.F_X02);
                d2.t(R.color.CAM_X0105);
                EMTextView eMTextView2 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_describe_view);
                this.t = eMTextView2;
                d.a.p0.s.u.c.d(eMTextView2).x(R.dimen.T_X08);
                EMTextView eMTextView3 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_cancel_view);
                this.q = eMTextView3;
                eMTextView3.setOnClickListener(new d(this));
                EMTextView eMTextView4 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_certain_view);
                this.r = eMTextView4;
                eMTextView4.setOnClickListener(new e(this));
            }
            this.v = (LinearLayout) this.p.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
            View g2 = this.l.g();
            if (g2 != null && g2.getParent() == null) {
                int g3 = l.g(this.f57209a, R.dimen.M_W_X009);
                g2.setPadding(g3, 0, g3, 0);
                this.v.addView(g2);
            }
            EMTextView eMTextView5 = (EMTextView) this.p.findViewById(R.id.ueg_new_delete_thread_tip_view);
            this.u = eMTextView5;
            eMTextView5.setHighlightColor(SelectorHelper.getResources().getColor(17170445));
            if (this.E) {
                this.u.setVisibility(0);
                if (1 == this.F) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) this.f57209a.getString(R.string.set_forum_rule_tip_manager));
                    f fVar = new f(this);
                    this.G = fVar;
                    spannableStringBuilder.setSpan(fVar, 13, 17, 18);
                    this.u.setText(spannableStringBuilder);
                    this.u.setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    this.u.setText(this.f57209a.getString(R.string.set_forum_rule_tip_assist));
                }
            } else {
                this.u.setVisibility(8);
            }
            this.u.setClickable(false);
            this.u.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.pic_popup_guide));
            s();
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ViewGroup viewGroup = this.p;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.p.getMeasuredHeight();
            this.f57216h = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.n = l.g(this.f57209a, R.dimen.M_W_X009);
            this.f57215g = l.k(this.f57209a) - (this.n * 2);
            d.a.q0.h.b bVar = new d.a.q0.h.b(this.f57210b);
            this.l = bVar;
            bVar.o(this.H);
            this.l.n(true);
            if (this.E) {
                this.l.l(5);
            }
        }
    }

    public final void y() {
        UserData userData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            i iVar = this.B;
            if (iVar != null) {
                if (iVar.e() == 1) {
                    this.D = false;
                } else {
                    this.D = true;
                }
                if (this.B.d() == 1) {
                    this.E = false;
                } else {
                    this.E = true;
                }
            }
            if (!this.E || (userData = this.C) == null) {
                return;
            }
            this.F = userData.getIs_manager();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.m && this.f57213e.size() != 0) {
            this.f57213e.clear();
        }
    }
}
