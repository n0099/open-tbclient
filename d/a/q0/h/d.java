package d.a.q0.h;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
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
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View.OnClickListener A;
    public Runnable B;
    public View.OnClickListener C;

    /* renamed from: a  reason: collision with root package name */
    public Context f57162a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57163b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.s.s.j f57164c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57165d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f57166e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f57167f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1401b> f57168g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.h.b f57169h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57170i;
    public int j;
    public int k;
    public int l;
    public TextView m;
    public TBSpecificationBtn n;
    public d.a.p0.s.f0.n.b o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public View s;
    public View t;
    public NEGFeedBackView.b u;
    public boolean v;
    public boolean w;
    public boolean x;
    public CustomMessageListener y;
    public CompoundButton.OnCheckedChangeListener z;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f57171a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
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
            this.f57171a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                this.f57171a.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57172e;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57172e = dVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f57172e.u != null) {
                    this.f57172e.u.onCheckedChanged(this.f57172e.f57166e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1401b) {
                    b.C1401b c1401b = (b.C1401b) compoundButton.getTag();
                    if (z) {
                        if (!this.f57172e.f57168g.contains(c1401b)) {
                            this.f57172e.f57168g.add(c1401b);
                        }
                    } else {
                        this.f57172e.f57168g.remove(c1401b);
                    }
                }
                if (ListUtils.isEmpty(this.f57172e.f57168g)) {
                    return;
                }
                d.a.d.e.m.e.a().removeCallbacks(this.f57172e.B);
                d.a.d.e.m.e.a().postDelayed(this.f57172e.B, 500L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57173e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57173e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57173e.h();
            }
        }
    }

    /* renamed from: d.a.q0.h.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1403d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57174e;

        public RunnableC1403d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57174e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57174e.m();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f57175e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57175e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57175e.m();
            }
        }
    }

    public d(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57164c = null;
        this.f57166e = null;
        this.f57167f = null;
        this.f57168g = new ArrayList();
        this.j = 3;
        this.u = null;
        this.v = true;
        this.w = true;
        this.x = false;
        this.y = new a(this, 2001304);
        this.z = new b(this);
        this.A = new c(this);
        this.B = new RunnableC1403d(this);
        this.C = new e(this);
        this.f57162a = tbPageContext.getPageActivity();
        this.f57163b = tbPageContext;
        l();
    }

    public final void g() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.j) {
            return;
        }
        d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.f57165d);
        d2.n(R.string.J_X14);
        d2.f(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0106);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
        this.j = skinType;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.p0.s.s.j jVar = this.f57164c;
            if (jVar != null) {
                jVar.dismiss();
                this.f57164c = null;
            }
            MessageManager.getInstance().unRegisterListener(this.y);
        }
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f57168g)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (b.C1401b c1401b : this.f57168g) {
                if (c1401b != null) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(c1401b.f57146c);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject j(ArrayList<Integer> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, arrayList)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f57166e == null || arrayList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (!ListUtils.isEmpty(this.f57168g)) {
                for (b.C1401b c1401b : this.f57168g) {
                    if (c1401b != null) {
                        arrayList.add(Integer.valueOf(c1401b.f57145b));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(c1401b.f57145b));
                        if (sb2.length() != 0) {
                            sb2.append(",");
                        }
                        sb2.append(c1401b.f57147d);
                    }
                }
            }
            try {
                jSONObject.put("tid", this.f57166e.e());
                if (sb.length() != 0) {
                    jSONObject.put("dislike_ids", sb.toString());
                }
                jSONObject.put("fid", this.f57166e.c());
                jSONObject.put("click_time", System.currentTimeMillis());
                if (!StringUtils.isNull(this.f57166e.h())) {
                    jSONObject.put("type", this.f57166e.h());
                }
                if (this.f57166e.g() != 0) {
                    jSONObject.put("topic_id", this.f57166e.g());
                }
                jSONObject.put("extra", sb2.toString());
                jSONObject.put("dislike_from", this.x ? "client_videomiddle" : "client_videotab");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = this.f57162a;
            if (context == null) {
                return null;
            }
            if (this.f57165d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f57165d = viewGroup;
                this.m = (TextView) viewGroup.findViewById(R.id.head_text);
                this.n = (TBSpecificationBtn) this.f57165d.findViewById(R.id.uninterested_btn);
                d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
                this.o = bVar;
                bVar.q(R.color.CAM_X0304);
                this.n.setConfig(this.o);
                this.n.setOnClickListener(this.C);
                this.n.setText(this.f57162a.getResources().getString(R.string.not_interested));
                this.n.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.f57165d;
                int i2 = this.k;
                viewGroup2.setPadding(i2, 0, i2, this.w ? 0 : this.l);
            }
            View h2 = this.f57169h.h();
            if (h2 != null && h2.getParent() == null) {
                this.f57165d.addView(h2);
            }
            if (this.p == null) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f57162a).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
                this.p = linearLayout;
                this.s = linearLayout.findViewById(R.id.top_line);
                this.r = (TextView) this.p.findViewById(R.id.dialog_bottom_cancel_button);
                this.q = (TextView) this.p.findViewById(R.id.dialog_bottom_certain_button);
                View findViewById = this.p.findViewById(R.id.middle_line);
                this.t = findViewById;
                findViewById.setVisibility(8);
                this.q.setVisibility(8);
                this.r.setOnClickListener(this.A);
                this.f57165d.addView(this.p);
            }
            return this.f57165d;
        }
        return (View) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.k = l.g(this.f57162a, R.dimen.M_W_X005);
            this.l = l.g(this.f57162a, R.dimen.M_H_X007);
            d.a.q0.h.b bVar = new d.a.q0.h.b(this.f57163b);
            this.f57169h = bVar;
            bVar.o(this.z);
            this.f57169h.n(true);
            this.f57169h.m(true);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f57166e == null || this.f57164c == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        JSONObject j = j(arrayList);
        if (this.v) {
            if (!StringUtils.isNull(this.f57166e.h())) {
                CustomMessage customMessage = new CustomMessage(2921324, this.f57163b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, j);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            } else {
                CustomMessage customMessage2 = new CustomMessage(2016488, this.f57163b.getUniqueId());
                CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, j);
                customResponsedMessage2.setOrginalMessage(customMessage2);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
            }
        }
        h();
        String string = this.f57162a.getResources().getString(R.string.reduce_related_thread_recommend);
        if (j != null && "7".equals(j.optString("dislike_ids"))) {
            string = this.f57162a.getResources().getString(R.string.forbidden_forum_success1);
        }
        l.M(this.f57162a, string);
        NEGFeedBackView.b bVar = this.u;
        if (bVar != null) {
            bVar.onNEGFeedbackConfirm(arrayList, i(), this.f57166e);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f57170i && this.f57168g.size() != 0) {
            this.f57168g.clear();
        }
    }

    public void o(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, w0Var) == null) || w0Var == null) {
            return;
        }
        this.f57166e = w0Var;
        SparseArray<String> b2 = w0Var.b();
        this.f57167f = b2;
        if (b2 != null && b2.size() > 9) {
            for (int size = this.f57167f.size() - 1; size >= 9; size--) {
                this.f57167f.removeAt(size);
            }
        }
        this.f57169h.j(w0Var);
    }

    public void p(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.u = bVar;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f57169h.m(z);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.x = z;
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f57162a == null) {
            return;
        }
        View k = k();
        if (k != null && k.getParent() != null) {
            ((ViewGroup) k.getParent()).removeView(k);
        }
        g();
        this.f57164c = new d.a.p0.s.s.j(this.f57163b);
        n();
        this.f57164c.setContentView(k);
        this.f57164c.show();
        TbPageContext tbPageContext = this.f57163b;
        if (tbPageContext != null) {
            tbPageContext.registerListener(this.y);
        }
        NEGFeedBackView.b bVar = this.u;
        if (bVar != null) {
            bVar.onNEGFeedbackWindowShow(this.f57166e);
        }
        this.f57170i = true;
    }
}
