package d.a.s0.v1.g;

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
import d.a.c.e.p.k;
import d.a.s0.v1.g.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MemberPrivilegeActivity f68421e;

    /* renamed from: f  reason: collision with root package name */
    public int f68422f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68423g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<Object> f68424h;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f68425a;

        /* renamed from: b  reason: collision with root package name */
        public RelativeLayout f68426b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f68427c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f68428d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f68429e;

        /* renamed from: f  reason: collision with root package name */
        public TbImageView f68430f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f68431g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f68432h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f68433i;
        public ImageView j;
        public ImageView k;
        public TextView l;
        public TextView m;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* renamed from: d.a.s0.v1.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1840c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HeadImageView f68434a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f68435b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f68436c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f68437d;

        public C1840c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1840c(a aVar) {
            this();
        }
    }

    /* loaded from: classes9.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f68438a;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public c(MemberPrivilegeActivity memberPrivilegeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memberPrivilegeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68423g = false;
        this.f68421e = memberPrivilegeActivity;
        this.f68424h = new ArrayList<>();
    }

    public final SpannableString a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SpannableString spannableString = new SpannableString(this.f68421e.getResources().getString(R.string.endtime_days_tip, str));
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 0, 4, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0308)), 4, 5, 33);
            spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0105)), 5, 16, 33);
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public void b(ArrayList<a.C1839a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<a.C1839a> it = arrayList.iterator();
        while (it.hasNext()) {
            a.C1839a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.f68407d) && TextUtils.getTrimmedLength(next.f68407d) > 0) {
                arrayList2.add(next);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    public final View c(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View inflate;
        b bVar;
        a.e eVar;
        a.b bVar2;
        a.d dVar;
        String string;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof b)) {
                bVar = (b) view.getTag();
                inflate = view;
            } else {
                inflate = LayoutInflater.from(this.f68421e.getPageContext().getContext()).inflate(R.layout.memberprivilege_headview, (ViewGroup) null);
                bVar = new b(null);
                bVar.f68425a = (HeadImageView) inflate.findViewById(R.id.head_portrait);
                bVar.f68426b = (RelativeLayout) inflate.findViewById(R.id.nonmember_stamp);
                bVar.f68429e = (TextView) inflate.findViewById(R.id.nonmembername);
                bVar.f68427c = (RelativeLayout) inflate.findViewById(R.id.member_stamp);
                bVar.f68428d = (TextView) inflate.findViewById(R.id.membername);
                bVar.f68430f = (TbImageView) inflate.findViewById(R.id.membericon);
                bVar.j = (ImageView) inflate.findViewById(R.id.vip_bean_icon);
                bVar.k = (ImageView) inflate.findViewById(R.id.nonmember_bean_icon);
                bVar.l = (TextView) inflate.findViewById(R.id.vip_tbean_num);
                bVar.m = (TextView) inflate.findViewById(R.id.nonmember_tbean_num);
                bVar.f68431g = (TextView) inflate.findViewById(R.id.endtime);
                bVar.f68432h = (TextView) inflate.findViewById(R.id.left_button);
                bVar.f68433i = (TextView) inflate.findViewById(R.id.right_button);
                inflate.setTag(bVar);
            }
            if (!TbadkApplication.getInst().appResponseToCmd(CmdConfigHttp.CMD_HTTP_GET_YINJI)) {
                bVar.f68433i.setVisibility(8);
            } else {
                bVar.f68433i.setVisibility(0);
            }
            if (getItem(i2) == null || (eVar = (a.e) getItem(i2)) == null || (bVar2 = eVar.f68419d) == null || (dVar = eVar.f68420e) == null) {
                return null;
            }
            long j = dVar.f68414a + dVar.f68415b;
            this.f68422f = (int) bVar2.f68408a;
            long j2 = bVar2.f68409b;
            String e2 = e(j2, bVar2.f68410c);
            bVar.f68425a.M(eVar.f68418c, 25, false);
            SkinManager.setBackgroundResource(bVar.f68425a, R.drawable.memberinfo_bg_shape);
            if (!dVar.a()) {
                j = 0;
            }
            if (bVar2.a() && dVar.a()) {
                bVar.f68426b.setVisibility(8);
                bVar.f68427c.setVisibility(0);
                bVar.f68430f.M(eVar.f68419d.f68411d, 21, false);
                if (this.f68423g) {
                    bVar.f68431g.setText(a(e2));
                    i3 = 1;
                } else {
                    if (1 == this.f68422f) {
                        string = this.f68421e.getPageContext().getString(R.string.member);
                    } else {
                        string = this.f68421e.getPageContext().getString(R.string.vip_member);
                    }
                    i3 = 1;
                    bVar.f68431g.setText(this.f68421e.getResources().getString(R.string.endtiem_memeber_tip, string, k.getDateStringDay(new Date(j2 * 1000))));
                    SkinManager.setViewTextColor(bVar.f68431g, R.color.CAM_X0101, 1);
                }
                bVar.f68428d.setText(eVar.f68417b);
                bVar.f68432h.setText(this.f68422f == i3 ? R.string.continue_member : R.string.continue_vip_member);
                bVar.f68432h.setOnClickListener(this.f68421e);
                bVar.l.setText(String.valueOf(j));
                SkinManager.setImageResource(bVar.j, R.drawable.icon_vip_dou);
            } else {
                bVar.f68426b.setVisibility(0);
                bVar.f68427c.setVisibility(8);
                bVar.f68429e.setText(eVar.f68417b);
                bVar.f68432h.setText(R.string.dredge_member);
                bVar.f68432h.setOnClickListener(this.f68421e);
                bVar.m.setText(String.valueOf(j));
                SkinManager.setImageResource(bVar.k, R.drawable.icon_vip_dou);
            }
            SkinManager.setBackgroundResource(bVar.f68431g, R.drawable.bg_dredge_tips);
            bVar.f68433i.setOnClickListener(this.f68421e);
            this.f68421e.getLayoutMode().k(z);
            this.f68421e.getLayoutMode().j(inflate);
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public final View d(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1840c c1840c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof C1840c)) {
                c1840c = (C1840c) view.getTag();
            } else {
                view = LayoutInflater.from(this.f68421e.getPageContext().getContext()).inflate(R.layout.memberprivilege_item, (ViewGroup) null);
                c1840c = new C1840c(null);
                c1840c.f68434a = (HeadImageView) view.findViewById(R.id.item_portrait);
                c1840c.f68435b = (TextView) view.findViewById(R.id.title);
                c1840c.f68436c = (TextView) view.findViewById(R.id.description);
                c1840c.f68437d = (ImageView) view.findViewById(R.id.divide_line_top);
                view.setTag(c1840c);
            }
            if (getItemViewType(i2 - 1) == 1) {
                c1840c.f68437d.setVisibility(8);
            }
            a.C1839a c1839a = (a.C1839a) getItem(i2);
            c1840c.f68434a.M(c1839a.f68404a, 10, false);
            c1840c.f68435b.setText(c1839a.f68405b);
            c1840c.f68436c.setText(c1839a.f68406c);
            this.f68421e.getLayoutMode().k(z);
            this.f68421e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final String e(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j - j2;
            int i2 = (0L > j3 ? 1 : (0L == j3 ? 0 : -1));
            if (i2 >= 0 || j3 > 345600) {
                return "";
            }
            this.f68423g = true;
            if (i2 >= 0 || j3 > 86400) {
                return (86400 >= j3 || j3 > ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME) ? (ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME >= j3 || j3 > 259200) ? "3" : "2" : "1";
            }
            return this.f68421e.getPageContext().getString(R.string.today);
        }
        return (String) invokeCommon.objValue;
    }

    public final View f(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            boolean z = TbadkApplication.getInst().getSkinType() == 1;
            if (view != null && view.getTag() != null && (view.getTag() instanceof d)) {
                dVar = (d) view.getTag();
            } else {
                view = LayoutInflater.from(this.f68421e.getPageContext().getContext()).inflate(R.layout.memberprivilege_titleview, (ViewGroup) null);
                dVar = new d(null);
                dVar.f68438a = (TextView) view.findViewById(R.id.title_view);
                view.setTag(dVar);
            }
            dVar.f68438a.setText((String) getItem(i2));
            this.f68421e.getLayoutMode().k(z);
            this.f68421e.getLayoutMode().j(view);
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public boolean g(ArrayList<a.C1839a> arrayList) {
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
            ArrayList<Object> arrayList = this.f68424h;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            ArrayList<Object> arrayList = this.f68424h;
            if (arrayList == null || i2 < 0 || i2 >= arrayList.size()) {
                return null;
            }
            return this.f68424h.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (this.f68424h != null && i2 >= 0 && i2 <= getCount() && i2 < this.f68424h.size()) {
                Object obj = this.f68424h.get(i2);
                if (obj instanceof a.e) {
                    return 0;
                }
                if (obj instanceof String) {
                    return 1;
                }
                if (obj instanceof a.C1839a) {
                    return 2;
                }
            }
            return 3;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                return c(i2, view, viewGroup);
            }
            if (itemViewType == 1) {
                return f(i2, view, viewGroup);
            }
            if (itemViewType == 2) {
                return d(i2, view, viewGroup);
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

    public void h(d.a.s0.v1.g.a aVar) {
        List<a.c> list;
        ArrayList<a.C1839a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f68424h.clear();
            if (aVar == null || aVar.f68402a == null || (list = aVar.f68403b) == null) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(aVar.f68402a);
            for (a.c cVar : list) {
                if (cVar != null && !TextUtils.isEmpty(cVar.f68412a) && (arrayList = cVar.f68413b) != null && arrayList.size() != 0 && g(cVar.f68413b)) {
                    arrayList2.add(cVar.f68412a);
                    Iterator<a.C1839a> it = cVar.f68413b.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(it.next());
                    }
                }
            }
            this.f68424h.addAll(arrayList2);
            notifyDataSetChanged();
        }
    }
}
