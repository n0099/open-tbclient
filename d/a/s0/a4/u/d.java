package d.a.s0.a4.u;

import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.q.w;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f57638e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<d.a.r0.r.f0.r.a> f57639f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<w> f57640g;

    /* renamed from: h  reason: collision with root package name */
    public b f57641h;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f57643f;

        public a(d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57643f = dVar;
            this.f57642e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.r0.r.f0.r.a g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f57643f.g(this.f57642e)) == null) {
                return;
            }
            if (this.f57643f.f57641h != null) {
                this.f57643f.f57641h.b(g2.e());
            }
            if (this.f57643f.f57641h != null) {
                this.f57643f.f57641h.a(this.f57643f.f57640g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(List<w> list);

        void b(int i2);
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f57644a;

        /* renamed from: b  reason: collision with root package name */
        public View f57645b;

        /* renamed from: c  reason: collision with root package name */
        public View f57646c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f57647d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57648e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f57649f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f57650g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f57651h;

        /* renamed from: i  reason: collision with root package name */
        public View f57652i;

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
                }
            }
        }

        public /* synthetic */ c(d dVar, a aVar) {
            this(dVar);
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
        this.f57640g = new LinkedList<>();
        this.f57638e = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57640g.clear();
            if (ListUtils.isEmpty(this.f57639f)) {
                return;
            }
            Iterator<d.a.r0.r.f0.r.a> it = this.f57639f.iterator();
            while (it.hasNext()) {
                d.a.r0.r.f0.r.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        w t = tbLinkSpanGroup.t();
                        t.t = tbLinkSpanGroup.f();
                        this.f57640g.add(t);
                    }
                }
            }
            Collections.sort(this.f57640g);
        }
    }

    public LinkedList<w> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57640g : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f57640g)) {
                return true;
            }
            Iterator<w> it = this.f57640g.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.f56075f == 2 || !next.m) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<d.a.r0.r.f0.r.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57639f : (LinkedList) invokeV.objValue;
    }

    public d.a.r0.r.f0.r.a g(int i2) {
        InterceptResult invokeI;
        LinkedList<d.a.r0.r.f0.r.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long itemId = getItemId(i2);
            if (itemId != 0 && (linkedList = this.f57639f) != null) {
                Iterator<d.a.r0.r.f0.r.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    d.a.r0.r.f0.r.a next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (d.a.r0.r.f0.r.a) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<w> linkedList = this.f57640g;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            LinkedList<w> linkedList = this.f57640g;
            if (linkedList == null || linkedList.size() <= i2) {
                return null;
            }
            return this.f57640g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            LinkedList<w> linkedList = this.f57640g;
            return (linkedList == null || linkedList.size() <= i2 || this.f57640g.get(i2) == null) ? 0 : this.f57640g.get(i2).f56074e;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            w wVar = (w) getItem(i2);
            if (wVar == null) {
                return null;
            }
            if (view == null) {
                view2 = LayoutInflater.from(this.f57638e.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.f57644a = view2.findViewById(R.id.commodity_root_view);
                cVar.f57645b = view2.findViewById(R.id.commodity_main_view);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.commodity_link_icon);
                cVar.f57647d = tbImageView;
                tbImageView.setConrers(15);
                cVar.f57647d.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                cVar.f57647d.setPlaceHolderAutoChangeSkinType(1);
                cVar.f57647d.setGifIconSupport(false);
                cVar.f57647d.setLongIconSupport(false);
                cVar.f57647d.setDrawBorder(true);
                cVar.f57647d.setBorderWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                cVar.f57647d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                cVar.f57648e = (TextView) view2.findViewById(R.id.commodity_link_content);
                cVar.f57649f = (ImageView) view2.findViewById(R.id.commodity_link_close_button);
                cVar.f57646c = view2.findViewById(R.id.extra_info_container);
                cVar.f57650g = (TextView) view2.findViewById(R.id.commodity_price);
                cVar.f57651h = (TextView) view2.findViewById(R.id.commodity_extra_infos);
                cVar.f57652i = view2.findViewById(R.id.commodity_tail_text_mask);
                view2.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            cVar.f57647d.M(wVar.f56078i, 10, false);
            if (TextUtils.isEmpty(wVar.j)) {
                cVar.f57646c.setVisibility(8);
                cVar.f57648e.setMaxLines(2);
            } else {
                cVar.f57646c.setVisibility(0);
                cVar.f57648e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(wVar.j)) {
                cVar.f57650g.setVisibility(8);
            } else {
                cVar.f57650g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), wVar.j));
                cVar.f57650g.setVisibility(0);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!TextUtils.isEmpty(wVar.p)) {
                spannableStringBuilder.append((CharSequence) wVar.p);
                int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
                int g3 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                int i3 = R.color.CAM_X0305;
                int g4 = l.g(TbadkCoreApplication.getInst(), R.dimen.T_X10);
                int g5 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
                int g6 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
                int g7 = l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X003);
                d.a.r0.r.f0.b bVar = new d.a.r0.r.f0.b(g2, -1, i3, g4, i3, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar.b(g3);
                bVar.h(g6);
                bVar.i(g7);
                spannableStringBuilder.setSpan(bVar, 0, wVar.p.length(), 17);
            }
            if (!wVar.r && wVar.f56075f != 2 && !wVar.m) {
                String str = wVar.k;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                cVar.f57648e.setMaxLines(1);
            } else {
                String str2 = wVar.f56076g;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            cVar.f57648e.setText(spannableStringBuilder);
            cVar.f57649f.setOnClickListener(new a(this, i2));
            l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            View view3 = cVar.f57644a;
            int i4 = R.color.CAM_X0205;
            SkinManager.setBackgroundShapeDrawable(view3, 0, i4, i4);
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(cVar.f57645b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            cVar.f57649f.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(cVar.f57648e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f57650g, R.color.CAM_X0305);
            SkinManager.setViewTextColor(cVar.f57651h, R.color.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(cVar.f57652i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c();
            notifyDataSetChanged();
        }
    }

    public void i(LinkedList<d.a.r0.r.f0.r.a> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.f57639f = linkedList;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f57641h = bVar;
        }
    }
}
