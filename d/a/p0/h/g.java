package d.a.p0.h;

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
import d.a.o0.r.q.w0;
import d.a.p0.h.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public d.a.o0.r.f0.a B;
    public CompoundButton.OnCheckedChangeListener C;
    public PopupWindow.OnDismissListener D;
    public CustomMessageListener E;

    /* renamed from: a  reason: collision with root package name */
    public Context f56641a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56642b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f56643c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56644d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f56645e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f56646f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1392b> f56647g;

    /* renamed from: h  reason: collision with root package name */
    public int f56648h;

    /* renamed from: i  reason: collision with root package name */
    public int f56649i;
    public int j;
    public NEGFeedBackView.b k;
    public PopupWindow l;
    public View m;
    public d.a.p0.h.b n;
    public boolean o;
    public int p;
    public int q;
    public LinearLayout r;
    public f s;
    public InterfaceC1395g t;
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
        public final /* synthetic */ g f56650e;

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
            this.f56650e = gVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f56650e.k != null) {
                    this.f56650e.k.onCheckedChanged(this.f56650e.f56645e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1392b) {
                    b.C1392b c1392b = (b.C1392b) compoundButton.getTag();
                    if (z) {
                        if (this.f56650e.f56647g.contains(c1392b)) {
                            return;
                        }
                        this.f56650e.f56647g.add(c1392b);
                        return;
                    }
                    this.f56650e.f56647g.remove(c1392b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f56651e;

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
            this.f56651e = gVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56651e.l == null) {
                return;
            }
            this.f56651e.l.dismiss();
            this.f56651e.l = null;
            MessageManager.getInstance().unRegisterListener(this.f56651e.E);
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f56652a;

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
            this.f56652a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f56652a.o();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f56653e;

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
            this.f56653e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f56653e.l != null) {
                    this.f56653e.l.dismiss();
                    this.f56653e.l = null;
                }
                if (this.f56653e.f56643c != null) {
                    this.f56653e.f56643c.dismiss();
                    this.f56653e.f56643c = null;
                }
                if (this.f56653e.s != null) {
                    this.f56653e.s.onClick();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f56654e;

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
            this.f56654e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                JSONObject r = this.f56654e.r();
                if (this.f56654e.A == "3" || this.f56654e.A == "4" || this.f56654e.A == "1") {
                    this.f56654e.q();
                } else if (r != null) {
                    this.f56654e.A();
                    CustomMessage customMessage = new CustomMessage(2016489, this.f56654e.f56642b.getUniqueId());
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

    /* renamed from: d.a.p0.h.g$g  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1395g {
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
        this.f56641a = null;
        this.f56643c = null;
        this.f56645e = null;
        this.f56646f = null;
        this.f56647g = new ArrayList();
        this.k = null;
        this.p = 3;
        this.B = null;
        this.C = new a(this);
        this.D = new b(this);
        this.E = new c(this, 2001304);
        this.f56641a = tbPageContext.getPageActivity();
        this.f56642b = tbPageContext;
        this.m = view;
        u();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.B == null) {
                this.B = new d.a.o0.r.f0.a(this.f56642b);
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
        SkinManager.setBackgroundColor(this.f56644d, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.v, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.x, R.color.CAM_X0109, 1);
        this.p = skinType;
    }

    public void p() {
        d.a.o0.r.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.B) == null) {
            return;
        }
        aVar.h(false);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PopupWindow popupWindow = this.f56643c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f56643c = null;
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
            if (this.f56645e == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int i2 = 0;
            if (!ListUtils.isEmpty(this.f56647g)) {
                int i3 = 0;
                while (i2 < this.f56647g.size()) {
                    b.C1392b c1392b = this.f56647g.get(i2);
                    if (c1392b != null) {
                        jSONArray.put(String.valueOf(c1392b.f56601b));
                        i3 = c1392b.f56600a + 1;
                    }
                    i2++;
                }
                i2 = i3;
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_DELETE_THREAD_REASON).param("obj_source", this.A).param("obj_type", i2));
            InterfaceC1395g interfaceC1395g = this.t;
            if (interfaceC1395g != null) {
                interfaceC1395g.a(jSONArray);
            }
            try {
                jSONObject.put("reason", jSONArray);
                jSONObject.put("thread_ids", this.f56645e.f());
                jSONObject.put("type", this.f56645e.a());
                jSONObject.put("forum_id", this.f56645e.c());
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
            Context context = this.f56641a;
            if (context == null) {
                return null;
            }
            if (this.f56644d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
                this.f56644d = viewGroup;
                this.w = (TextView) viewGroup.findViewById(R.id.head_text);
                this.x = (TextView) this.f56644d.findViewById(R.id.sub_head_text);
            }
            View g2 = this.n.g();
            if (g2 != null && g2.getParent() == null) {
                int g3 = l.g(this.f56641a, R.dimen.ds40);
                g2.setPadding(g3, 0, g3, 0);
                this.f56644d.addView(g2);
            }
            if (this.r == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f56641a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.r = linearLayout;
                this.v = (TextView) linearLayout.findViewById(R.id.dialog_bottom_cancel_button);
                this.u = (TextView) this.r.findViewById(R.id.dialog_bottom_certain_button);
                this.y = this.r.findViewById(R.id.top_line);
                this.z = this.r.findViewById(R.id.middle_line);
                this.f56644d.addView(this.r);
                this.v.setOnClickListener(new d(this));
                TextView textView = this.u;
                if (textView != null) {
                    textView.setOnClickListener(new e(this));
                }
                o();
            }
            return this.f56644d;
        }
        return (View) invokeV.objValue;
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ViewGroup viewGroup = this.f56644d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f56644d.getMeasuredHeight() + l.g(this.f56641a, R.dimen.ds12);
            this.j = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.q = l.g(this.f56641a, R.dimen.tbds32);
            this.f56649i = l.k(this.f56641a) - (this.q * 2);
            d.a.p0.h.b bVar = new d.a.p0.h.b(this.f56642b);
            this.n = bVar;
            bVar.o(this.C);
            this.n.n(true);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.o && this.f56647g.size() != 0) {
            this.f56647g.clear();
        }
    }

    public void w(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, w0Var) == null) || w0Var == null) {
            return;
        }
        this.f56645e = w0Var;
        SparseArray<String> b2 = w0Var.b();
        this.f56646f = b2;
        if (b2 != null && b2.size() > 8) {
            for (int size = this.f56646f.size() - 1; size >= 8; size--) {
                this.f56646f.removeAt(size);
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

    public void y(InterfaceC1395g interfaceC1395g) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, interfaceC1395g) == null) {
            this.t = interfaceC1395g;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || this.f56641a == null) {
            return;
        }
        this.A = str;
        View s = s();
        if (s != null && s.getParent() != null) {
            ((ViewGroup) s.getParent()).removeView(s);
        }
        o();
        this.f56648h = t() - l.g(this.f56641a, R.dimen.ds12);
        PopupWindow popupWindow = new PopupWindow(s, this.f56649i, this.f56648h);
        this.f56643c = popupWindow;
        popupWindow.setFocusable(true);
        this.f56643c.setTouchable(true);
        this.f56643c.setOnDismissListener(this.D);
        v();
        PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f56641a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
        this.l = popupWindow2;
        if (Build.VERSION.SDK_INT >= 22) {
            popupWindow2.setAttachedInDecor(false);
        }
        this.l.showAtLocation(this.m, 0, 0, 0);
        SkinManager.setBackgroundDrawable(this.f56643c, R.drawable.bg_dailog);
        this.f56643c.showAtLocation(this.m, 17, 0, 0);
        NEGFeedBackView.b bVar = this.k;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f56645e);
        }
        this.o = true;
        this.f56642b.registerListener(this.E);
    }
}
