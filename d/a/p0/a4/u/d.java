package d.a.p0.a4.u;

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
import d.a.o0.r.q.w;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f54383e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<d.a.o0.r.f0.s.a> f54384f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<w> f54385g;

    /* renamed from: h  reason: collision with root package name */
    public b f54386h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54387e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f54388f;

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
            this.f54388f = dVar;
            this.f54387e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.o0.r.f0.s.a g2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (g2 = this.f54388f.g(this.f54387e)) == null) {
                return;
            }
            if (this.f54388f.f54386h != null) {
                this.f54388f.f54386h.b(g2.e());
            }
            if (this.f54388f.f54386h != null) {
                this.f54388f.f54386h.a(this.f54388f.f54385g);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(List<w> list);

        void b(int i2);
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f54389a;

        /* renamed from: b  reason: collision with root package name */
        public View f54390b;

        /* renamed from: c  reason: collision with root package name */
        public View f54391c;

        /* renamed from: d  reason: collision with root package name */
        public TbImageView f54392d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f54393e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f54394f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f54395g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f54396h;

        /* renamed from: i  reason: collision with root package name */
        public View f54397i;

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
        this.f54385g = new LinkedList<>();
        this.f54383e = tbPageContext;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f54385g.clear();
            if (ListUtils.isEmpty(this.f54384f)) {
                return;
            }
            Iterator<d.a.o0.r.f0.s.a> it = this.f54384f.iterator();
            while (it.hasNext()) {
                d.a.o0.r.f0.s.a next = it.next();
                if (next.h() && (next instanceof TbLinkSpanGroup)) {
                    TbLinkSpanGroup tbLinkSpanGroup = (TbLinkSpanGroup) next;
                    if (tbLinkSpanGroup.t() != null) {
                        w t = tbLinkSpanGroup.t();
                        t.t = tbLinkSpanGroup.f();
                        this.f54385g.add(t);
                    }
                }
            }
            Collections.sort(this.f54385g);
        }
    }

    public LinkedList<w> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f54385g : (LinkedList) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (ListUtils.isEmpty(this.f54385g)) {
                return true;
            }
            Iterator<w> it = this.f54385g.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (next.f52794f == 2 || !next.m) {
                    return false;
                }
                while (it.hasNext()) {
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public LinkedList<d.a.o0.r.f0.s.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f54384f : (LinkedList) invokeV.objValue;
    }

    public d.a.o0.r.f0.s.a g(int i2) {
        InterceptResult invokeI;
        LinkedList<d.a.o0.r.f0.s.a> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long itemId = getItemId(i2);
            if (itemId != 0 && (linkedList = this.f54384f) != null) {
                Iterator<d.a.o0.r.f0.s.a> it = linkedList.iterator();
                while (it.hasNext()) {
                    d.a.o0.r.f0.s.a next = it.next();
                    if (next.e() == itemId) {
                        return next;
                    }
                }
            }
            return null;
        }
        return (d.a.o0.r.f0.s.a) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinkedList<w> linkedList = this.f54385g;
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
            LinkedList<w> linkedList = this.f54385g;
            if (linkedList == null || linkedList.size() <= i2) {
                return null;
            }
            return this.f54385g.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            LinkedList<w> linkedList = this.f54385g;
            return (linkedList == null || linkedList.size() <= i2 || this.f54385g.get(i2) == null) ? 0 : this.f54385g.get(i2).f52793e;
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
                view2 = LayoutInflater.from(this.f54383e.getPageActivity()).inflate(R.layout.item_commodity_link, (ViewGroup) null);
                cVar = new c(this, null);
                cVar.f54389a = view2.findViewById(R.id.commodity_root_view);
                cVar.f54390b = view2.findViewById(R.id.commodity_main_view);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.commodity_link_icon);
                cVar.f54392d = tbImageView;
                tbImageView.setConrers(15);
                cVar.f54392d.setRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                cVar.f54392d.setPlaceHolderAutoChangeSkinType(1);
                cVar.f54392d.setGifIconSupport(false);
                cVar.f54392d.setLongIconSupport(false);
                cVar.f54392d.setDrawBorder(true);
                cVar.f54392d.setBorderWidth(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                cVar.f54392d.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                cVar.f54393e = (TextView) view2.findViewById(R.id.commodity_link_content);
                cVar.f54394f = (ImageView) view2.findViewById(R.id.commodity_link_close_button);
                cVar.f54391c = view2.findViewById(R.id.extra_info_container);
                cVar.f54395g = (TextView) view2.findViewById(R.id.commodity_price);
                cVar.f54396h = (TextView) view2.findViewById(R.id.commodity_extra_infos);
                cVar.f54397i = view2.findViewById(R.id.commodity_tail_text_mask);
                view2.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            cVar.f54392d.M(wVar.f52797i, 10, false);
            if (TextUtils.isEmpty(wVar.j)) {
                cVar.f54391c.setVisibility(8);
                cVar.f54393e.setMaxLines(2);
            } else {
                cVar.f54391c.setVisibility(0);
                cVar.f54393e.setMaxLines(1);
            }
            if (TextUtils.isEmpty(wVar.j)) {
                cVar.f54395g.setVisibility(8);
            } else {
                cVar.f54395g.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.commodity_price_prefix), wVar.j));
                cVar.f54395g.setVisibility(0);
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
                d.a.o0.r.f0.b bVar = new d.a.o0.r.f0.b(g2, -1, i3, g4, i3, g5, l.g(TbadkCoreApplication.getInst(), R.dimen.tbds38));
                bVar.b(g3);
                bVar.h(g6);
                bVar.i(g7);
                spannableStringBuilder.setSpan(bVar, 0, wVar.p.length(), 17);
            }
            if (!wVar.r && wVar.f52794f != 2 && !wVar.m) {
                String str = wVar.k;
                if (str != null) {
                    spannableStringBuilder.append((CharSequence) str);
                }
                cVar.f54393e.setMaxLines(1);
            } else {
                String str2 = wVar.f52795g;
                if (str2 != null) {
                    spannableStringBuilder.append((CharSequence) str2);
                }
            }
            cVar.f54393e.setText(spannableStringBuilder);
            cVar.f54394f.setOnClickListener(new a(this, i2));
            l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            View view3 = cVar.f54389a;
            int i4 = R.color.CAM_X0205;
            SkinManager.setBackgroundShapeDrawable(view3, 0, i4, i4);
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(cVar.f54390b);
            d2.n(R.string.J_X05);
            d2.f(R.color.CAM_X0206);
            cVar.f54394f.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
            SkinManager.setViewTextColor(cVar.f54393e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(cVar.f54395g, R.color.CAM_X0305);
            SkinManager.setViewTextColor(cVar.f54396h, R.color.CAM_X0109);
            SkinManager.setBackgroundColorToTransparent(cVar.f54397i, R.color.CAM_X0206, GradientDrawable.Orientation.RIGHT_LEFT);
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

    public void i(LinkedList<d.a.o0.r.f0.s.a> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, linkedList) == null) {
            this.f54384f = linkedList;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            this.f54386h = bVar;
        }
    }
}
