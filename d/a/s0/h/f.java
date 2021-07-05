package d.a.s0.h;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.q.w0;
import d.a.s0.h.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public d.a.r0.r.f0.a B;
    public CompoundButton.OnCheckedChangeListener C;
    public PopupWindow.OnDismissListener D;
    public CustomMessageListener E;

    /* renamed from: a  reason: collision with root package name */
    public Context f59885a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59886b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f59887c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f59888d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f59889e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f59890f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1438b> f59891g;

    /* renamed from: h  reason: collision with root package name */
    public int f59892h;

    /* renamed from: i  reason: collision with root package name */
    public int f59893i;
    public int j;
    public NEGFeedBackView.b k;
    public PopupWindow l;
    public View m;
    public d.a.s0.h.b n;
    public boolean o;
    public int p;
    public int q;
    public LinearLayout r;
    public InterfaceC1440f s;
    public g t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* loaded from: classes9.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f59894e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59894e = fVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f59894e.k != null) {
                    this.f59894e.k.onCheckedChanged(this.f59894e.f59889e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1438b) {
                    b.C1438b c1438b = (b.C1438b) compoundButton.getTag();
                    if (z) {
                        if (this.f59894e.f59891g.contains(c1438b)) {
                            return;
                        }
                        this.f59894e.f59891g.add(c1438b);
                        return;
                    }
                    this.f59894e.f59891g.remove(c1438b);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f59895e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59895e = fVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59895e.l == null) {
                return;
            }
            this.f59895e.l.dismiss();
            this.f59895e.l = null;
            MessageManager.getInstance().unRegisterListener(this.f59895e.E);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f59896a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f59896a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f59896a.o();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f59897e;

        public d(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59897e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f59897e.l != null) {
                    this.f59897e.l.dismiss();
                    this.f59897e.l = null;
                }
                if (this.f59897e.f59887c != null) {
                    this.f59897e.f59887c.dismiss();
                    this.f59897e.f59887c = null;
                }
                if (this.f59897e.s != null) {
                    this.f59897e.s.onClick();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f59898e;

        public e(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59898e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                JSONObject r = this.f59898e.r();
                if (this.f59898e.A == "3" || this.f59898e.A == "4" || this.f59898e.A == "1") {
                    this.f59898e.q();
                } else if (r != null) {
                    this.f59898e.A();
                    CustomMessage customMessage = new CustomMessage(2016489, this.f59898e.f59886b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, r);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }
    }

    /* renamed from: d.a.s0.h.f$f  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1440f {
        void onClick();
    }

    /* loaded from: classes9.dex */
    public interface g {
        void a(JSONArray jSONArray);
    }

    public f(TbPageContext tbPageContext, View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59885a = null;
        this.f59887c = null;
        this.f59889e = null;
        this.f59890f = null;
        this.f59891g = new ArrayList();
        this.k = null;
        this.p = 3;
        this.B = null;
        this.C = new a(this);
        this.D = new b(this);
        this.E = new c(this, 2001304);
        this.f59885a = tbPageContext.getPageActivity();
        this.f59886b = tbPageContext;
        this.m = view;
        u();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.B == null) {
                this.B = new d.a.r0.r.f0.a(this.f59886b);
            }
            this.B.i(R.string.loading);
            this.B.h(true);
        }
    }

    public final void o() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.p) {
            return;
        }
        SkinManager.setBackgroundColor(this.f59888d, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.x, R.color.CAM_X0109, 1);
        this.p = skinType;
    }

    public void p() {
        d.a.r0.r.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.B) == null) {
            return;
        }
        aVar.h(false);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PopupWindow popupWindow = this.f59887c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f59887c = null;
            }
            PopupWindow popupWindow2 = this.l;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.l = null;
            }
        }
    }

    public final JSONObject r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f59889e == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.f59891g)) {
                int i3 = 0;
                while (i2 < this.f59891g.size()) {
                    b.C1438b c1438b = this.f59891g.get(i2);
                    if (c1438b != null) {
                        jSONArray.put(String.valueOf(c1438b.f59859b));
                        i3 = c1438b.f59858a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.A).param("obj_type", i2));
            g gVar = this.t;
            if (gVar != null) {
                gVar.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.f59889e.f());
                jSONObject.put("type", this.f59889e.a());
                jSONObject.put("forum_id", this.f59889e.c());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Context context = this.f59885a;
            if (context == null) {
                return null;
            }
            if (this.f59888d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
                this.f59888d = viewGroup;
                this.w = (TextView) viewGroup.findViewById(R.id.head_text);
                this.x = (TextView) this.f59888d.findViewById(R.id.sub_head_text);
            }
            View g2 = this.n.g();
            if (g2 != null && g2.getParent() == null) {
                int g3 = l.g(this.f59885a, R.dimen.ds40);
                g2.setPadding(g3, 0, g3, 0);
                this.f59888d.addView(g2);
            }
            if (this.r == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f59885a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.r = linearLayout;
                this.v = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
                this.u = (TextView) this.r.findViewById(R.id.dialog_bottom_certain_button);
                this.y = this.r.findViewById(R.id.top_line);
                this.z = this.r.findViewById(R.id.middle_line);
                this.f59888d.addView(this.r);
                this.v.setOnClickListener(new d(this));
                TextView textView = this.u;
                if (textView != null) {
                    textView.setOnClickListener(new e(this));
                }
                o();
            }
            return this.f59888d;
        }
        return (View) invokeV.objValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ViewGroup viewGroup = this.f59888d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f59888d.getMeasuredHeight() + l.g(this.f59885a, R.dimen.ds12);
            this.j = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q = l.g(this.f59885a, R.dimen.tbds32);
            this.f59893i = l.k(this.f59885a) - (this.q * 2);
            d.a.s0.h.b bVar = new d.a.s0.h.b(this.f59886b);
            this.n = bVar;
            bVar.o(this.C);
            this.n.n(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.o && this.f59891g.size() != 0) {
            this.f59891g.clear();
        }
    }

    public void w(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, w0Var) == null) || w0Var == null) {
            return;
        }
        this.f59889e = w0Var;
        SparseArray<String> b2 = w0Var.b();
        this.f59890f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f59890f.size() - 1; size >= 8; size--) {
                this.f59890f.removeAt(size);
            }
        }
        this.n.j(w0Var);
    }

    public void x(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, strArr) == null) {
            this.n.k(strArr);
        }
    }

    public void y(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.t = gVar;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || this.f59885a == null) {
            return;
        }
        this.A = str;
        View s = s();
        if (s != null && s.getParent() != null) {
            ((ViewGroup) s.getParent()).removeView(s);
        }
        o();
        this.f59892h = t() - l.g(this.f59885a, R.dimen.ds12);
        PopupWindow popupWindow = new PopupWindow(s, this.f59893i, this.f59892h);
        this.f59887c = popupWindow;
        popupWindow.setFocusable(true);
        this.f59887c.setTouchable(true);
        this.f59887c.setOnDismissListener(this.D);
        v();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f59885a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.l = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.l.showAtLocation(this.m, 0, 0, 0);
        SkinManager.setBackgroundDrawable(this.f59887c, R.drawable.bg_dailog);
        this.f59887c.showAtLocation(this.m, 17, 0, 0);
        NEGFeedBackView.b bVar = this.k;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f59889e);
        }
        this.o = true;
        this.f59886b.registerListener(this.E);
    }
}
