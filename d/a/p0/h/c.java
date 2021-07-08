package d.a.p0.h;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.q.w0;
import d.a.p0.h.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static String G;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CompoundButton.OnCheckedChangeListener B;
    public Runnable C;
    public View.OnClickListener D;
    public PopupWindow.OnDismissListener E;
    public CustomMessageListener F;

    /* renamed from: a  reason: collision with root package name */
    public Context f56604a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56605b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f56606c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56607d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f56608e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f56609f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1392b> f56610g;

    /* renamed from: h  reason: collision with root package name */
    public int f56611h;

    /* renamed from: i  reason: collision with root package name */
    public int f56612i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public NEGFeedBackView.b p;
    public PopupWindow q;
    public View r;
    public TextView s;
    public TBSpecificationBtn t;
    public d.a.o0.r.f0.n.b u;
    public d.a.p0.h.b v;
    public boolean w;
    public int x;
    public NEGFeedBackView y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f56613e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56613e = cVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f56613e.p != null) {
                    this.f56613e.p.onCheckedChanged(this.f56613e.f56608e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1392b) {
                    b.C1392b c1392b = (b.C1392b) compoundButton.getTag();
                    if (z) {
                        if (!this.f56613e.f56610g.contains(c1392b)) {
                            this.f56613e.f56610g.add(c1392b);
                        }
                    } else {
                        this.f56613e.f56610g.remove(c1392b);
                    }
                }
                if (this.f56613e.y == null || ListUtils.isEmpty(this.f56613e.f56610g)) {
                    return;
                }
                this.f56613e.y.removeCallbacks(this.f56613e.C);
                this.f56613e.y.postDelayed(this.f56613e.C, 500L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f56614e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56614e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56614e.s();
            }
        }
    }

    /* renamed from: d.a.p0.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1393c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f56615e;

        public View$OnClickListenerC1393c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56615e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56615e.s();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f56616e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56616e = cVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f56616e.y != null) {
                    this.f56616e.y.setACRotateAnimation();
                    this.f56616e.y.removeCallbacks(this.f56616e.C);
                    this.f56616e.y = null;
                }
                if (this.f56616e.q != null) {
                    this.f56616e.q.dismiss();
                    this.f56616e.q = null;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f56617a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f56617a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f56617a.l();
            }
        }
    }

    public c(TbPageContext tbPageContext, View view) {
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
        this.f56604a = null;
        this.f56606c = null;
        this.f56608e = null;
        this.f56609f = null;
        this.f56610g = new ArrayList();
        this.p = null;
        this.x = 3;
        this.z = true;
        this.A = false;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new View$OnClickListenerC1393c(this);
        this.E = new d(this);
        this.F = new e(this, 2016524);
        this.f56604a = tbPageContext.getPageActivity();
        this.f56605b = tbPageContext;
        this.r = view;
        q();
    }

    public void A(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        CustomMessageListener customMessageListener = this.F;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
        }
        MessageManager.getInstance().registerListener(this.F);
    }

    public void B(View view) {
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f56604a == null) {
            return;
        }
        if (this.A || !((sparseArray = this.f56609f) == null || sparseArray.size() == 0)) {
            NEGFeedBackView nEGFeedBackView = (NEGFeedBackView) view;
            this.y = nEGFeedBackView;
            nEGFeedBackView.setCWRotateAnimation();
            View m = m();
            this.f56612i = l.k(this.f56604a) - (this.l * 2);
            int p = p();
            this.f56611h = p;
            int[] iArr = new int[2];
            boolean j = j(this.f56604a, this.r, p, this.f56612i, this.k, this.m, iArr);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
            gradientDrawable.setCornerRadius(l.g(this.f56604a, R.dimen.tbds31));
            m.setBackgroundDrawable(gradientDrawable);
            PopupWindow popupWindow = new PopupWindow(m, this.f56612i, p());
            this.f56606c = popupWindow;
            popupWindow.setFocusable(true);
            this.f56606c.setTouchable(true);
            this.f56606c.setOnDismissListener(this.E);
            t();
            PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f56604a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.q = popupWindow2;
            if (Build.VERSION.SDK_INT >= 22) {
                popupWindow2.setAttachedInDecor(false);
            }
            this.q.showAtLocation(this.r, 0, 0, 0);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.f56606c.setBackgroundDrawable(new ColorDrawable(0));
            if (j) {
                this.f56606c.setAnimationStyle(R.style.scale_rb2lt_anim);
            } else {
                this.f56606c.setAnimationStyle(R.style.scale_rt2lb_anim);
            }
            this.f56606c.showAtLocation(this.r, 0, iArr[0] - this.l, iArr[1]);
            NEGFeedBackView.b bVar = this.p;
            if (bVar != null) {
                bVar.onNEGFeedbackWindowShow(this.f56608e);
            }
            this.w = true;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.A = z;
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int size = this.f56610g.size();
            if (size > 0) {
                String string = this.f56604a.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)));
                TextView textView = this.s;
                if (textView != null) {
                    textView.setText(spannableString);
                }
                TBSpecificationBtn tBSpecificationBtn = this.t;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setText(this.f56604a.getResources().getString(R.string.confirm));
                    return;
                }
                return;
            }
            if (this.s != null) {
                if (!k.isEmpty(G)) {
                    this.s.setText(G);
                } else {
                    this.s.setText(this.f56604a.getResources().getString(R.string.tell_us_reason));
                }
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.t;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.setText(this.f56604a.getResources().getString(R.string.not_interested));
            }
        }
    }

    public final boolean j(Context context, View view, int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{context, view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) {
            if (context == null || view == null || iArr == null || iArr.length != 2) {
                return false;
            }
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int height = view.getHeight();
            int i6 = l.i(context);
            int k = l.k(context);
            boolean z = ((i6 - iArr2[1]) - height) - i4 < i2;
            iArr[0] = k - i3;
            if (z) {
                iArr[1] = (iArr2[1] - i2) - i5;
                iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            } else {
                iArr[1] = iArr2[1] + height + i5;
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public final void k() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.x) {
            return;
        }
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        this.x = skinType;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PopupWindow popupWindow = this.f56606c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f56606c = null;
            }
            PopupWindow popupWindow2 = this.q;
            if (popupWindow2 != null) {
                popupWindow2.dismiss();
                this.q = null;
            }
        }
    }

    public final View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = this.f56604a;
            if (context == null) {
                return null;
            }
            if (this.f56607d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f56607d = viewGroup;
                this.s = (TextView) viewGroup.findViewById(R.id.head_text);
                if (!k.isEmpty(G)) {
                    this.s.setText(G);
                }
                this.t = (TBSpecificationBtn) this.f56607d.findViewById(R.id.uninterested_btn);
                d.a.o0.r.f0.n.b bVar = new d.a.o0.r.f0.n.b();
                this.u = bVar;
                bVar.q(R.color.CAM_X0304);
                this.t.setConfig(this.u);
                this.t.setOnClickListener(this.D);
                this.t.setText(this.f56604a.getResources().getString(R.string.not_interested));
                this.t.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.f56607d;
                int i2 = this.n;
                viewGroup2.setPadding(i2, 0, i2, this.A ? 0 : this.o);
            }
            k();
            View h2 = this.v.h();
            if (h2 != null && h2.getParent() == null) {
                this.f56607d.addView(h2);
            }
            return this.f56607d;
        }
        return (View) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (ListUtils.isEmpty(this.f56610g)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (b.C1392b c1392b : this.f56610g) {
                if (c1392b != null) {
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(c1392b.f56602c);
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final JSONObject o(ArrayList<Integer> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, arrayList)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f56608e == null || arrayList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (!ListUtils.isEmpty(this.f56610g)) {
                for (b.C1392b c1392b : this.f56610g) {
                    if (c1392b != null) {
                        arrayList.add(Integer.valueOf(c1392b.f56601b));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                        sb.append(String.valueOf(c1392b.f56601b));
                        if (sb2.length() != 0) {
                            sb2.append(",");
                        }
                        sb2.append(c1392b.f56603d);
                    }
                }
            }
            try {
                jSONObject.put("tid", this.f56608e.e());
                if (sb.length() != 0) {
                    jSONObject.put("dislike_ids", sb.toString());
                }
                jSONObject.put("fid", this.f56608e.c());
                jSONObject.put("click_time", System.currentTimeMillis());
                if (!StringUtils.isNull(this.f56608e.h())) {
                    jSONObject.put("type", this.f56608e.h());
                }
                if (this.f56608e.g() != 0) {
                    jSONObject.put("topic_id", this.f56608e.g());
                }
                jSONObject.put("extra", sb2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ViewGroup viewGroup = this.f56607d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f56607d.getMeasuredHeight();
            this.j = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = l.g(this.f56604a, R.dimen.M_W_X004);
            this.m = l.g(this.f56604a, R.dimen.tbds14);
            this.n = l.g(this.f56604a, R.dimen.M_W_X005);
            this.o = l.g(this.f56604a, R.dimen.M_H_X007);
            this.f56612i = l.k(this.f56604a) - (this.l * 2);
            this.k = l.g(this.f56604a, R.dimen.tbds160);
            d.a.p0.h.b bVar = new d.a.p0.h.b(this.f56605b);
            this.v = bVar;
            bVar.n(true);
            this.v.i(false);
            this.v.o(this.B);
            this.f56605b.registerListener(this.F);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.F);
            l();
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f56608e == null || this.f56606c == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        JSONObject o = o(arrayList);
        if (this.z) {
            if (!StringUtils.isNull(this.f56608e.h())) {
                CustomMessage customMessage = new CustomMessage(2921324, this.f56605b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, o);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            } else {
                CustomMessage customMessage2 = new CustomMessage(2016488, this.f56605b.getUniqueId());
                CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, o);
                customResponsedMessage2.setOrginalMessage(customMessage2);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
            }
        }
        l();
        d.a.o0.r.f0.c cVar = new d.a.o0.r.f0.c();
        cVar.f52333a = 1500L;
        String string = this.f56604a.getResources().getString(R.string.reduce_related_thread_recommend);
        if (o != null && "7".equals(o.optString("dislike_ids"))) {
            string = this.f56604a.getResources().getString(R.string.forbidden_forum_success);
        }
        cVar.c(string);
        NEGFeedBackView.b bVar = this.p;
        if (bVar != null) {
            bVar.onNEGFeedbackConfirm(arrayList, n(), this.f56608e);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.w && this.f56610g.size() != 0) {
            this.f56610g.clear();
            D();
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.z = z;
        }
    }

    public void v(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, w0Var) == null) || w0Var == null) {
            return;
        }
        this.f56608e = w0Var;
        SparseArray<String> b2 = w0Var.b();
        this.f56609f = b2;
        if (b2 != null && b2.size() > 9) {
            for (int size = this.f56609f.size() - 1; size >= 9; size--) {
                this.f56609f.removeAt(size);
            }
        }
        this.v.j(w0Var);
    }

    public void w(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, strArr) == null) {
            this.v.k(strArr);
        }
    }

    public void x(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.v.m(z);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || k.isEmpty(str)) {
            return;
        }
        G = str;
    }
}
