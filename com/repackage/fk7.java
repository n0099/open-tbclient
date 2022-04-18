package com.repackage;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberprivilege.MemberPrivilegeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ek7;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class fk7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MemberPrivilegeActivity a;
    public int b;
    public boolean c;
    public ArrayList<Object> d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public RelativeLayout b;
        public RelativeLayout c;
        public TextView d;
        public TextView e;
        public TbImageView f;
        public TextView g;
        public TextView h;
        public TextView i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HeadImageView a;
        public TextView b;
        public TextView c;
        public ImageView d;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public fk7(MemberPrivilegeActivity memberPrivilegeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberPrivilegeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = false;
        this.a = memberPrivilegeActivity;
        this.d = new ArrayList<>();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SpannableString spannableString = new SpannableString(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f055f, str));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public void b(ArrayList<ek7.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<ek7.a> it = arrayList.iterator();
        while (it.hasNext()) {
            ek7.a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.d) && TextUtils.getTrimmedLength(next.d) > 0) {
                arrayList2.add(next);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    public final View c(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View inflate;
        b bVar;
        ek7.e eVar;
        ek7.b bVar2;
        ek7.d dVar;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, view2, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof b)) {
                bVar = (b) view2.getTag();
                inflate = view2;
            } else {
                inflate = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d054a, (ViewGroup) null);
                bVar = new b(null);
                bVar.a = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090d2d);
                bVar.b = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0915a9);
                bVar.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915ab);
                bVar.c = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0913dc);
                bVar.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0913e1);
                bVar.f = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0913e0);
                bVar.j = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0923cd);
                bVar.k = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0915a8);
                bVar.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0923d6);
                bVar.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0915aa);
                bVar.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0908db);
                bVar.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091211);
                bVar.i = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a98);
                inflate.setTag(bVar);
            }
            if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
                bVar.i.setVisibility(8);
            } else {
                bVar.i.setVisibility(0);
            }
            if (getItem(i) == null || (eVar = (ek7.e) getItem(i)) == null || (bVar2 = eVar.d) == null || (dVar = eVar.e) == null) {
                return null;
            }
            long j = dVar.a + dVar.b;
            this.b = (int) bVar2.a;
            long j2 = bVar2.b;
            String e = e(j2, bVar2.c);
            bVar.a.K(eVar.c, 25, false);
            SkinManager.setBackgroundResource(bVar.a, R.drawable.memberinfo_bg_shape);
            if (!dVar.a()) {
                j = 0;
            }
            if (bVar2.a() && dVar.a()) {
                bVar.b.setVisibility(8);
                bVar.c.setVisibility(0);
                bVar.f.K(eVar.d.d, 21, false);
                if (this.c) {
                    bVar.g.setText(a(e));
                    i2 = 1;
                } else {
                    if (1 == this.b) {
                        string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a9c);
                    } else {
                        string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1510);
                    }
                    i2 = 1;
                    bVar.g.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f055e, string, ni.getDateStringDay(new Date(j2 * 1000))));
                    SkinManager.setViewTextColor(bVar.g, R.color.CAM_X0101, 1);
                }
                bVar.d.setText(eVar.b);
                bVar.h.setText(this.b == i2 ? R.string.obfuscated_res_0x7f0f0438 : R.string.obfuscated_res_0x7f0f043a);
                bVar.h.setOnClickListener(this.a);
                bVar.l.setText(String.valueOf(j));
                SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
            } else {
                bVar.b.setVisibility(0);
                bVar.c.setVisibility(8);
                bVar.e.setText(eVar.b);
                bVar.h.setText(R.string.obfuscated_res_0x7f0f050a);
                bVar.h.setOnClickListener(this.a);
                bVar.m.setText(String.valueOf(j));
                SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
            }
            SkinManager.setBackgroundResource(bVar.g, R.drawable.bg_dredge_tips);
            bVar.i.setOnClickListener(this.a);
            this.a.getLayoutMode().k(z);
            this.a.getLayoutMode().j(inflate);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final View d(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof c)) {
                cVar = (c) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d054b, (ViewGroup) null);
                cVar = new c(null);
                cVar.a = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f85);
                cVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092013);
                cVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09078c);
                cVar.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907e3);
                view2.setTag(cVar);
            }
            if (getItemViewType(i - 1) == 1) {
                cVar.d.setVisibility(8);
            }
            ek7.a aVar = (ek7.a) getItem(i);
            cVar.a.K(aVar.a, 10, false);
            cVar.b.setText(aVar.b);
            cVar.c.setText(aVar.c);
            this.a.getLayoutMode().k(z);
            this.a.getLayoutMode().j(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final String e(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j - j2;
            int i = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
            if (i >= 0 || j3 > 345600) {
                return "";
            }
            this.c = true;
            if (i >= 0 || j3 > 86400) {
                return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
            }
            return this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1401);
        }
        return (String) invokeCommon.objValue;
    }

    public final View f(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view2, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view2 != null && view2.getTag() != null && (view2.getTag() instanceof d)) {
                dVar = (d) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.a.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d054c, (ViewGroup) null);
                dVar = new d(null);
                dVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092045);
                view2.setTag(dVar);
            }
            dVar.a.setText((String) getItem(i));
            this.a.getLayoutMode().k(z);
            this.a.getLayoutMode().j(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public boolean g(ArrayList<ek7.a> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                b(arrayList);
                if (arrayList.size() > 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList<Object> arrayList = this.d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            ArrayList<Object> arrayList = this.d;
            if (arrayList == null || i < 0 || i >= arrayList.size()) {
                return null;
            }
            return this.d.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.d != null && i >= 0 && i <= getCount() && i < this.d.size()) {
                Object obj = this.d.get(i);
                if (obj instanceof ek7.e) {
                    return 0;
                }
                if (obj instanceof String) {
                    return 1;
                }
                if (obj instanceof ek7.a) {
                    return 2;
                }
            }
            return 3;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                return c(i, view2, viewGroup);
            }
            if (itemViewType == 1) {
                return f(i, view2, viewGroup);
            }
            if (itemViewType == 2) {
                return d(i, view2, viewGroup);
            }
            if (itemViewType == 3) {
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    public void h(ek7 ek7Var) {
        List<ek7.c> list;
        ArrayList<ek7.a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ek7Var) == null) {
            this.d.clear();
            if (ek7Var == null || ek7Var.a == null || (list = ek7Var.b) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(ek7Var.a);
            for (ek7.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.a) && (arrayList = cVar.b) != null && arrayList.size() != 0 && g(cVar.b)) {
                    arrayList2.add(cVar.a);
                    Iterator<ek7.a> it = cVar.b.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next());
                    }
                }
            }
            this.d.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }
}
