package d.a.q0.h;

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
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.s.q.w0;
import d.a.q0.h.b;
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
    public Context f57148a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f57149b;

    /* renamed from: c  reason: collision with root package name */
    public PopupWindow f57150c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f57151d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f57152e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<String> f57153f;

    /* renamed from: g  reason: collision with root package name */
    public List<b.C1401b> f57154g;

    /* renamed from: h  reason: collision with root package name */
    public int f57155h;

    /* renamed from: i  reason: collision with root package name */
    public int f57156i;
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
    public d.a.p0.s.f0.n.b u;
    public d.a.q0.h.b v;
    public boolean w;
    public int x;
    public NEGFeedBackView y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57157e;

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
            this.f57157e = cVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) {
                if (this.f57157e.p != null) {
                    this.f57157e.p.onCheckedChanged(this.f57157e.f57152e, compoundButton, z);
                }
                if (compoundButton.getTag() instanceof b.C1401b) {
                    b.C1401b c1401b = (b.C1401b) compoundButton.getTag();
                    if (z) {
                        if (!this.f57157e.f57154g.contains(c1401b)) {
                            this.f57157e.f57154g.add(c1401b);
                        }
                    } else {
                        this.f57157e.f57154g.remove(c1401b);
                    }
                }
                if (this.f57157e.y == null || ListUtils.isEmpty(this.f57157e.f57154g)) {
                    return;
                }
                this.f57157e.y.removeCallbacks(this.f57157e.C);
                this.f57157e.y.postDelayed(this.f57157e.C, 500L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57158e;

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
            this.f57158e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57158e.s();
            }
        }
    }

    /* renamed from: d.a.q0.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1402c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57159e;

        public View$OnClickListenerC1402c(c cVar) {
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
            this.f57159e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57159e.s();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f57160e;

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
            this.f57160e = cVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f57160e.y != null) {
                    this.f57160e.y.setACRotateAnimation();
                    this.f57160e.y.removeCallbacks(this.f57160e.C);
                    this.f57160e.y = null;
                }
                if (this.f57160e.q != null) {
                    this.f57160e.q.dismiss();
                    this.f57160e.q = null;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57161a;

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
            this.f57161a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f57161a.l();
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
        this.f57148a = null;
        this.f57150c = null;
        this.f57152e = null;
        this.f57153f = null;
        this.f57154g = new ArrayList();
        this.p = null;
        this.x = 3;
        this.z = true;
        this.A = false;
        this.B = new a(this);
        this.C = new b(this);
        this.D = new View$OnClickListenerC1402c(this);
        this.E = new d(this);
        this.F = new e(this, 2016524);
        this.f57148a = tbPageContext.getPageActivity();
        this.f57149b = tbPageContext;
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f57148a == null) {
            return;
        }
        if (this.A || !((sparseArray = this.f57153f) == null || sparseArray.size() == 0)) {
            NEGFeedBackView nEGFeedBackView = (NEGFeedBackView) view;
            this.y = nEGFeedBackView;
            nEGFeedBackView.setCWRotateAnimation();
            View m = m();
            this.f57156i = l.k(this.f57148a) - (this.l * 2);
            int p = p();
            this.f57155h = p;
            int[] iArr = new int[2];
            boolean j = j(this.f57148a, this.r, p, this.f57156i, this.k, this.m, iArr);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0204));
            gradientDrawable.setCornerRadius(l.g(this.f57148a, R.dimen.tbds31));
            m.setBackgroundDrawable(gradientDrawable);
            PopupWindow popupWindow = new PopupWindow(m, this.f57156i, p());
            this.f57150c = popupWindow;
            popupWindow.setFocusable(true);
            this.f57150c.setTouchable(true);
            this.f57150c.setOnDismissListener(this.E);
            t();
            PopupWindow popupWindow2 = new PopupWindow(LayoutInflater.from(this.f57148a).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.q = popupWindow2;
            if (Build.VERSION.SDK_INT >= 22) {
                popupWindow2.setAttachedInDecor(false);
            }
            this.q.showAtLocation(this.r, 0, 0, 0);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.f57150c.setBackgroundDrawable(new ColorDrawable(0));
            if (j) {
                this.f57150c.setAnimationStyle(R.style.scale_rb2lt_anim);
            } else {
                this.f57150c.setAnimationStyle(R.style.scale_rt2lb_anim);
            }
            this.f57150c.showAtLocation(this.r, 0, iArr[0] - this.l, iArr[1]);
            NEGFeedBackView.b bVar = this.p;
            if (bVar != null) {
                bVar.onNEGFeedbackWindowShow(this.f57152e);
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
            int size = this.f57154g.size();
            if (size > 0) {
                String string = this.f57148a.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
                SpannableString spannableString = new SpannableString(string);
                UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0302)));
                TextView textView = this.s;
                if (textView != null) {
                    textView.setText(spannableString);
                }
                TBSpecificationBtn tBSpecificationBtn = this.t;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setText(this.f57148a.getResources().getString(R.string.confirm));
                    return;
                }
                return;
            }
            if (this.s != null) {
                if (!k.isEmpty(G)) {
                    this.s.setText(G);
                } else {
                    this.s.setText(this.f57148a.getResources().getString(R.string.tell_us_reason));
                }
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.t;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.setText(this.f57148a.getResources().getString(R.string.not_interested));
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
            PopupWindow popupWindow = this.f57150c;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f57150c = null;
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
            Context context = this.f57148a;
            if (context == null) {
                return null;
            }
            if (this.f57151d == null) {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
                this.f57151d = viewGroup;
                this.s = (TextView) viewGroup.findViewById(R.id.head_text);
                if (!k.isEmpty(G)) {
                    this.s.setText(G);
                }
                this.t = (TBSpecificationBtn) this.f57151d.findViewById(R.id.uninterested_btn);
                d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
                this.u = bVar;
                bVar.q(R.color.CAM_X0304);
                this.t.setConfig(this.u);
                this.t.setOnClickListener(this.D);
                this.t.setText(this.f57148a.getResources().getString(R.string.not_interested));
                this.t.setTextSize(R.dimen.T_X08);
                ViewGroup viewGroup2 = this.f57151d;
                int i2 = this.n;
                viewGroup2.setPadding(i2, 0, i2, this.A ? 0 : this.o);
            }
            k();
            View h2 = this.v.h();
            if (h2 != null && h2.getParent() == null) {
                this.f57151d.addView(h2);
            }
            return this.f57151d;
        }
        return (View) invokeV.objValue;
    }

    public final String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (ListUtils.isEmpty(this.f57154g)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (b.C1401b c1401b : this.f57154g) {
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

    public final JSONObject o(ArrayList<Integer> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, arrayList)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.f57152e == null || arrayList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (!ListUtils.isEmpty(this.f57154g)) {
                for (b.C1401b c1401b : this.f57154g) {
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
                jSONObject.put("tid", this.f57152e.e());
                if (sb.length() != 0) {
                    jSONObject.put("dislike_ids", sb.toString());
                }
                jSONObject.put("fid", this.f57152e.c());
                jSONObject.put("click_time", System.currentTimeMillis());
                if (!StringUtils.isNull(this.f57152e.h())) {
                    jSONObject.put("type", this.f57152e.h());
                }
                if (this.f57152e.g() != 0) {
                    jSONObject.put("topic_id", this.f57152e.g());
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
            ViewGroup viewGroup = this.f57151d;
            if (viewGroup == null) {
                return 0;
            }
            viewGroup.measure(0, 0);
            int measuredHeight = this.f57151d.getMeasuredHeight();
            this.j = measuredHeight;
            return measuredHeight;
        }
        return invokeV.intValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = l.g(this.f57148a, R.dimen.M_W_X004);
            this.m = l.g(this.f57148a, R.dimen.tbds14);
            this.n = l.g(this.f57148a, R.dimen.M_W_X005);
            this.o = l.g(this.f57148a, R.dimen.M_H_X007);
            this.f57156i = l.k(this.f57148a) - (this.l * 2);
            this.k = l.g(this.f57148a, R.dimen.tbds160);
            d.a.q0.h.b bVar = new d.a.q0.h.b(this.f57149b);
            this.v = bVar;
            bVar.n(true);
            this.v.i(false);
            this.v.o(this.B);
            this.f57149b.registerListener(this.F);
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
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f57152e == null || this.f57150c == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        JSONObject o = o(arrayList);
        if (this.z) {
            if (!StringUtils.isNull(this.f57152e.h())) {
                CustomMessage customMessage = new CustomMessage(2921324, this.f57149b.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, o);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            } else {
                CustomMessage customMessage2 = new CustomMessage(2016488, this.f57149b.getUniqueId());
                CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, o);
                customResponsedMessage2.setOrginalMessage(customMessage2);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
            }
        }
        l();
        d.a.p0.s.f0.c cVar = new d.a.p0.s.f0.c();
        cVar.f52989a = 1500L;
        String string = this.f57148a.getResources().getString(R.string.reduce_related_thread_recommend);
        if (o != null && "7".equals(o.optString("dislike_ids"))) {
            string = this.f57148a.getResources().getString(R.string.forbidden_forum_success);
        }
        cVar.c(string);
        NEGFeedBackView.b bVar = this.p;
        if (bVar != null) {
            bVar.onNEGFeedbackConfirm(arrayList, n(), this.f57152e);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.w && this.f57154g.size() != 0) {
            this.f57154g.clear();
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
        this.f57152e = w0Var;
        SparseArray<String> b2 = w0Var.b();
        this.f57153f = b2;
        if (b2 != null && b2.size() > 9) {
            for (int size = this.f57153f.size() - 1; size >= 9; size--) {
                this.f57153f.removeAt(size);
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
