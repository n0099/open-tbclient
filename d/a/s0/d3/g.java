package d.a.s0.d3;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignSingleModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import d.a.c.e.p.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes9.dex */
public class g extends BaseAdapter implements AbsListView.OnScrollListener, SignSingleModel.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d> f58211e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.d3.c f58212f;

    /* renamed from: g  reason: collision with root package name */
    public SignAllForumActivity f58213g;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, SignSingleModel> f58214h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58215i;
    public boolean j;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f58216e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f58217f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f58218g;

        public a(g gVar, d dVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, dVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58218g = gVar;
            this.f58216e = dVar;
            this.f58217f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f58216e.k()) {
                return;
            }
            this.f58217f.f58229i.setVisibility(4);
            this.f58217f.j.setVisibility(0);
            this.f58217f.k.setText(R.string.signallforum_resigning);
            this.f58216e.t(true);
            SignSingleModel signSingleModel = new SignSingleModel(this.f58218g.f58213g);
            signSingleModel.F(this.f58218g);
            String str = this.f58216e.c() + "";
            synchronized (this.f58218g) {
                this.f58218g.f58214h.put(str, signSingleModel);
            }
            signSingleModel.G(this.f58216e.d(), str);
            TiebaStatic.log("signall_resign_click");
        }
    }

    /* loaded from: classes9.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f58219a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f58220b;

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
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public BarImageView f58221a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f58222b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58223c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f58224d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f58225e;

        /* renamed from: f  reason: collision with root package name */
        public FrameLayout f58226f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f58227g;

        /* renamed from: h  reason: collision with root package name */
        public RelativeLayout f58228h;

        /* renamed from: i  reason: collision with root package name */
        public ImageView f58229i;
        public ProgressBar j;
        public TextView k;
        public TextView l;
        public TextView m;

        public c(g gVar) {
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
                }
            }
        }
    }

    public g(SignAllForumActivity signAllForumActivity, TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity, textView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f58211e = new ArrayList<>();
        this.f58214h = new HashMap<>();
        this.j = true;
        this.f58213g = signAllForumActivity;
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void a(SignData signData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, signData) == null) {
            String str = signData.forumId;
            synchronized (this) {
                this.f58214h.remove(str);
            }
            i(str, true, signData, null);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f58215i = true;
            synchronized (this) {
                try {
                    for (Map.Entry<String, SignSingleModel> entry : this.f58214h.entrySet()) {
                        entry.getValue().E();
                    }
                    this.f58214h.clear();
                }
            }
        }
    }

    public final View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            View inflate = LayoutInflater.from(this.f58213g.getPageContext().getPageActivity()).inflate(R.layout.sign_all_forum_nodata_item, (ViewGroup) null);
            NoDataView a2 = NoDataViewFactory.a(this.f58213g.getPageContext().getPageActivity(), (LinearLayout) inflate.findViewById(R.id.sign_all_forum_no_data_view), NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, this.f58213g.getResources().getDimensionPixelSize(R.dimen.tbds90)), NoDataViewFactory.e.d(null, this.f58213g.getResources().getString(R.string.no_bar_attentioned)), null);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f58213g.getLayoutMode().k(skinType == 1);
            this.f58213g.getLayoutMode().j(inflate);
            a2.f(this.f58213g.getPageContext(), skinType);
            a2.setVisibility(0);
            a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public final View f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 0) {
                View inflate = LayoutInflater.from(this.f58213g.getPageContext().getPageActivity()).inflate(R.layout.signallforum_item, (ViewGroup) null);
                c cVar = new c(this);
                BarImageView barImageView = (BarImageView) inflate.findViewById(R.id.signallforum_item_avatar);
                cVar.f58221a = barImageView;
                barImageView.setIsRound(false);
                cVar.f58221a.setGifIconSupport(false);
                cVar.f58223c = (TextView) inflate.findViewById(R.id.signallforum_item_name);
                cVar.f58224d = (ImageView) inflate.findViewById(R.id.signallforum_item_level);
                cVar.f58225e = (TextView) inflate.findViewById(R.id.signallforum_item_exp);
                cVar.f58226f = (FrameLayout) inflate.findViewById(R.id.signallforum_item_res_container);
                cVar.f58227g = (TextView) inflate.findViewById(R.id.signallforum_item_days);
                cVar.f58228h = (RelativeLayout) inflate.findViewById(R.id.signallforum_item_resign_container);
                cVar.f58229i = (ImageView) inflate.findViewById(R.id.signallforum_item_resign_icon);
                cVar.j = (ProgressBar) inflate.findViewById(R.id.signallforum_item_resign_progress);
                cVar.k = (TextView) inflate.findViewById(R.id.signallforum_item_resign_text);
                cVar.l = (TextView) inflate.findViewById(R.id.signallforum_item_error);
                cVar.f58222b = (LinearLayout) inflate.findViewById(R.id.signallforum_item_level_container);
                cVar.m = (TextView) inflate.findViewById(R.id.signallforum_item_increaseexp);
                inflate.setTag(cVar);
                return inflate;
            }
            View inflate2 = LayoutInflater.from(this.f58213g.getPageContext().getPageActivity()).inflate(R.layout.signallforum_header, (ViewGroup) null);
            b bVar = new b(this);
            bVar.f58219a = (TextView) inflate2.findViewById(R.id.signallforum_head_title);
            bVar.f58220b = (TextView) inflate2.findViewById(R.id.signallforum_head_res);
            inflate2.setTag(bVar);
            return inflate2;
        }
        return (View) invokeI.objValue;
    }

    public final void g(View view, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, view, view2, i2) == null) {
            this.f58213g.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.f58213g.getLayoutMode().j(view);
            c cVar = (c) view.getTag();
            d dVar = (d) getItem(i2);
            if (dVar == null) {
                return;
            }
            String d2 = dVar.d();
            if (d2 != null && d2.length() > 8) {
                char[] charArray = d2.toCharArray();
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= charArray.length) {
                        break;
                    }
                    i4 = StringUtils.isChinese(charArray[i3]) ? i4 + 2 : i4 + 1;
                    if (i4 > 16) {
                        d2 = d2.substring(0, i3) + StringHelper.STRING_MORE;
                        break;
                    }
                    i3++;
                }
            }
            cVar.f58223c.setText(d2);
            SkinManager.setImageResource(cVar.f58224d, BitmapHelper.getSmallGradeResourceIdNew(dVar.i()));
            cVar.f58225e.setText(dVar.h() + "/" + dVar.g());
            cVar.m.clearAnimation();
            if (dVar.l()) {
                cVar.f58222b.setVisibility(0);
                cVar.l.setVisibility(8);
                cVar.f58227g.setVisibility(0);
                cVar.f58228h.setVisibility(8);
                cVar.f58227g.setText(String.format(this.f58213g.getPageContext().getString(R.string.signallforum_days), Integer.valueOf(dVar.b())));
                if (dVar.m()) {
                    cVar.f58225e.setText(this.f58213g.getPageContext().getString(R.string.signallforum_uplevel));
                    cVar.m.setVisibility(8);
                } else {
                    cVar.f58225e.setText(dVar.h() + "/" + dVar.g());
                    cVar.m.setVisibility(0);
                }
                int e2 = dVar.e();
                if (e2 > 0) {
                    cVar.m.setVisibility(0);
                    cVar.m.setText(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + e2);
                } else {
                    cVar.m.setVisibility(8);
                }
            } else if (dVar.j()) {
                cVar.f58222b.setVisibility(0);
                cVar.l.setVisibility(8);
                cVar.m.setVisibility(8);
                cVar.f58227g.setVisibility(8);
                cVar.f58228h.setVisibility(0);
                if (dVar.k()) {
                    cVar.f58229i.setVisibility(4);
                    cVar.j.setVisibility(0);
                    cVar.k.setText(R.string.signallforum_resigning);
                } else {
                    cVar.f58229i.setVisibility(0);
                    cVar.j.setVisibility(4);
                    cVar.k.setText(R.string.signallforum_resign);
                }
                cVar.f58228h.setOnClickListener(new a(this, dVar, cVar));
            } else {
                cVar.f58227g.setVisibility(8);
                cVar.f58228h.setVisibility(8);
                cVar.m.setVisibility(8);
                cVar.f58222b.setVisibility(0);
                cVar.l.setVisibility(8);
            }
            String a2 = dVar.a();
            cVar.f58221a.setTag(a2);
            cVar.f58221a.setPlaceHolder(1);
            cVar.f58221a.M(a2, 10, false);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.j) {
                return this.f58211e.size();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.f58211e.size() > i2) {
                return this.f58211e.get(i2);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) ? getItem(i2) instanceof d.a.s0.d3.b ? 1 : 0 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            if (!this.j) {
                return e();
            }
            int itemViewType = getItemViewType(i2);
            if (view == null) {
                view = f(itemViewType);
            }
            if (itemViewType == 1) {
                if (view.getTag() != null && (view.getTag() instanceof b)) {
                    bVar = (b) view.getTag();
                } else {
                    view = f(itemViewType);
                    bVar = (b) view.getTag();
                }
                this.f58213g.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                this.f58213g.getLayoutMode().j(view.findViewById(R.id.sign_all_forum_tip));
                bVar.f58219a.setText(((d.a.s0.d3.b) getItem(i2)).x());
                j(bVar.f58220b, i2);
            } else {
                if (view.getTag() == null || !(view.getTag() instanceof c)) {
                    view = f(itemViewType);
                }
                g(view, viewGroup, i2);
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void h(d.a.s0.d3.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) || cVar == null) {
            return;
        }
        this.f58212f = cVar;
        ArrayList<d> k = cVar.k();
        this.f58211e = k;
        if (k.size() == 0) {
            this.j = false;
        } else {
            this.j = true;
        }
        notifyDataSetChanged();
    }

    public final void i(String str, boolean z, SignData signData, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), signData, str2}) == null) {
            int size = this.f58211e.size();
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = this.f58211e.get(i2);
                if ((dVar.c() + "").equals(str)) {
                    dVar.u(z);
                    dVar.s(!z);
                    dVar.t(false);
                    if (z) {
                        dVar.o(signData.count_sign_num);
                        dVar.q(signData.sign_bonus_point);
                        dVar.r(1);
                        TbadkApplication.getInst().addSignedForum(dVar.d(), signData.sign_bonus_point, -1);
                        ArrayList<d> x = this.f58212f.x();
                        if (x.contains(dVar)) {
                            x.remove(dVar);
                            this.f58212f.r().add(dVar);
                        }
                    } else {
                        dVar.p(str2);
                    }
                    if (this.f58215i) {
                        return;
                    }
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public final void j(TextView textView, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, textView, i2) == null) {
            d.a.s0.d3.c cVar = this.f58212f;
            int l = cVar == null ? 7 : cVar.l();
            ArrayList<d> arrayList = this.f58211e;
            if (arrayList == null || arrayList.size() <= 0) {
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
            } else {
                Iterator<d> it = this.f58211e.iterator();
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                while (it.hasNext()) {
                    d next = it.next();
                    if (!TextUtils.isEmpty(next.d())) {
                        if (next.i() >= l) {
                            if (next.l()) {
                                i3++;
                            } else {
                                i4++;
                            }
                        } else if (next.l()) {
                            i5++;
                        } else {
                            i6++;
                        }
                    }
                }
            }
            if (i2 == 0 && i3 + i4 > 0) {
                format = String.format(this.f58213g.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i3), Integer.valueOf(i4));
            } else {
                format = String.format(this.f58213g.getPageContext().getString(R.string.signallforum_res), Integer.valueOf(i5), Integer.valueOf(i6));
            }
            textView.setText(format);
        }
    }

    @Override // com.baidu.tieba.signall.SignSingleModel.b
    public void onError(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            if (!TextUtils.isEmpty(str2)) {
                l.M(this.f58213g.getPageContext().getPageActivity(), str2);
            }
            synchronized (this) {
                this.f58214h.remove(str);
            }
            i(str, false, null, str2);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048591, this, absListView, i2, i3, i4) == null) {
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048592, this, absListView, i2) == null) && i2 == 0) {
            notifyDataSetChanged();
        }
    }
}
