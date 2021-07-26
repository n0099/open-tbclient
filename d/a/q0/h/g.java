package d.a.q0.h;

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
import d.a.d.e.p.l;
import d.a.p0.s.q.w0;
import d.a.q0.h.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public d.a.p0.s.f0.a B;
    public CompoundButton.OnCheckedChangeListener C;
    public PopupWindow.OnDismissListener D;
    public CustomMessageListener E;

    /* renamed from: a  reason: collision with root package name */
    public Context f57185a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57186b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f57187c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57188d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f57189e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f57190f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1401b> f57191g;

    /* renamed from: h  reason: collision with root package name */
    public int f57192h;

    /* renamed from: i  reason: collision with root package name */
    public int f57193i;
    public int j;
    public NEGFeedBackView.b k;
    public PopupWindow l;
    public View m;
    public d.a.q0.h.b n;
    public boolean o;
    public int p;
    public int q;
    public LinearLayout r;
    public f s;
    public InterfaceC1404g t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    /* loaded from: classes8.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f57194e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57194e = gVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f57194e.k != null) {
                    this.f57194e.k.onCheckedChanged(this.f57194e.f57189e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1401b) {
                    b.C1401b c1401b = (b.C1401b) compoundButton.getTag();
                    if (z) {
                        if (this.f57194e.f57191g.contains(c1401b)) {
                            return;
                        }
                        this.f57194e.f57191g.add(c1401b);
                        return;
                    }
                    this.f57194e.f57191g.remove(c1401b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f57195e;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57195e = gVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57195e.l == null) {
                return;
            }
            this.f57195e.l.dismiss();
            this.f57195e.l = null;
            MessageManager.getInstance().unRegisterListener(this.f57195e.E);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f57196a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g gVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Integer.valueOf(i2)};
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
            this.f57196a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f57196a.o();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f57197e;

        public d(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57197e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57197e.l != null) {
                    this.f57197e.l.dismiss();
                    this.f57197e.l = null;
                }
                if (this.f57197e.f57187c != null) {
                    this.f57197e.f57187c.dismiss();
                    this.f57197e.f57187c = null;
                }
                if (this.f57197e.s != null) {
                    this.f57197e.s.onClick();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f57198e;

        public e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57198e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                JSONObject r = this.f57198e.r();
                if (this.f57198e.A == "3" || this.f57198e.A == "4" || this.f57198e.A == "1") {
                    this.f57198e.q();
                } else if (r != null) {
                    this.f57198e.A();
                    CustomMessage customMessage = new CustomMessage(2016489, this.f57198e.f57186b.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, r);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface f {
        void onClick();
    }

    /* renamed from: d.a.q0.h.g$g  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1404g {
        void a(JSONArray jSONArray);
    }

    public g(TbPageContext tbPageContext, View view) {
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
        this.f57185a = null;
        this.f57187c = null;
        this.f57189e = null;
        this.f57190f = null;
        this.f57191g = new ArrayList();
        this.k = null;
        this.p = 3;
        this.B = null;
        this.C = new a(this);
        this.D = new b(this);
        this.E = new c(this, 2001304);
        this.f57185a = tbPageContext.getPageActivity();
        this.f57186b = tbPageContext;
        this.m = view;
        u();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.B == null) {
                this.B = new d.a.p0.s.f0.a(this.f57186b);
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
        SkinManager.setBackgroundColor(this.f57188d, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.x, R.color.CAM_X0109, 1);
        this.p = skinType;
    }

    public void p() {
        d.a.p0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.B) == null) {
            return;
        }
        aVar.h(false);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PopupWindow popupWindow = this.f57187c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f57187c = null;
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
            if (this.f57189e == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.f57191g)) {
                int i3 = 0;
                while (i2 < this.f57191g.size()) {
                    b.C1401b c1401b = this.f57191g.get(i2);
                    if (c1401b != null) {
                        jSONArray.put(String.valueOf(c1401b.f57145b));
                        i3 = c1401b.f57144a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.A).param("obj_type", i2));
            InterfaceC1404g interfaceC1404g = this.t;
            if (interfaceC1404g != null) {
                interfaceC1404g.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.f57189e.f());
                jSONObject.put("type", this.f57189e.a());
                jSONObject.put("forum_id", this.f57189e.c());
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
            Context context = this.f57185a;
            if (context == null) {
                return null;
            }
            if (this.f57188d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
                this.f57188d = viewGroup;
                this.w = (TextView) viewGroup.findViewById(R.id.head_text);
                this.x = (TextView) this.f57188d.findViewById(R.id.sub_head_text);
            }
            View g2 = this.n.g();
            if (g2 != null && g2.getParent() == null) {
                int g3 = l.g(this.f57185a, R.dimen.ds40);
                g2.setPadding(g3, 0, g3, 0);
                this.f57188d.addView(g2);
            }
            if (this.r == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f57185a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.r = linearLayout;
                this.v = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
                this.u = (TextView) this.r.findViewById(R.id.dialog_bottom_certain_button);
                this.y = this.r.findViewById(R.id.top_line);
                this.z = this.r.findViewById(R.id.middle_line);
                this.f57188d.addView(this.r);
                this.v.setOnClickListener(new d(this));
                TextView textView = this.u;
                if (textView != null) {
                    textView.setOnClickListener(new e(this));
                }
                o();
            }
            return this.f57188d;
        }
        return (View) invokeV.objValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ViewGroup viewGroup = this.f57188d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f57188d.getMeasuredHeight() + l.g(this.f57185a, R.dimen.ds12);
            this.j = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q = l.g(this.f57185a, R.dimen.tbds32);
            this.f57193i = l.k(this.f57185a) - (this.q * 2);
            d.a.q0.h.b bVar = new d.a.q0.h.b(this.f57186b);
            this.n = bVar;
            bVar.o(this.C);
            this.n.n(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.o && this.f57191g.size() != 0) {
            this.f57191g.clear();
        }
    }

    public void w(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, w0Var) == null) || w0Var == null) {
            return;
        }
        this.f57189e = w0Var;
        SparseArray<String> b2 = w0Var.b();
        this.f57190f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f57190f.size() - 1; size >= 8; size--) {
                this.f57190f.removeAt(size);
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

    public void y(InterfaceC1404g interfaceC1404g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC1404g) == null) {
            this.t = interfaceC1404g;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || this.f57185a == null) {
            return;
        }
        this.A = str;
        View s = s();
        if (s != null && s.getParent() != null) {
            ((ViewGroup) s.getParent()).removeView(s);
        }
        o();
        this.f57192h = t() - l.g(this.f57185a, R.dimen.ds12);
        PopupWindow popupWindow = new PopupWindow(s, this.f57193i, this.f57192h);
        this.f57187c = popupWindow;
        popupWindow.setFocusable(true);
        this.f57187c.setTouchable(true);
        this.f57187c.setOnDismissListener(this.D);
        v();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f57185a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.l = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.l.showAtLocation(this.m, 0, 0, 0);
        SkinManager.setBackgroundDrawable(this.f57187c, R.drawable.bg_dailog);
        this.f57187c.showAtLocation(this.m, 17, 0, 0);
        NEGFeedBackView.b bVar = this.k;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f57189e);
        }
        this.o = true;
        this.f57186b.registerListener(this.E);
    }
}
