package d.a.s0.z3.m.e.b;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes9.dex */
public class a extends BaseAdapter implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f70140i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.s0.z3.m.e.c.b> f70141e;

    /* renamed from: f  reason: collision with root package name */
    public String f70142f;

    /* renamed from: g  reason: collision with root package name */
    public int f70143g;

    /* renamed from: h  reason: collision with root package name */
    public RecordEffectLayout.i f70144h;

    /* renamed from: d.a.s0.z3.m.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1922a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f70145a;

        /* renamed from: b  reason: collision with root package name */
        public ProgressBar f70146b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f70147c;

        /* renamed from: d  reason: collision with root package name */
        public int f70148d;

        public C1922a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1349518212, "Ld/a/s0/z3/m/e/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1349518212, "Ld/a/s0/z3/m/e/b/a;");
                return;
            }
        }
        f70140i = UtilHelper.getDimenPixelSize(R.dimen.tbds156);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f70143g = -1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.s0.z3.m.e.c.b getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            List<d.a.s0.z3.m.e.c.b> list = this.f70141e;
            if (list != null && i2 >= 0 && i2 < list.size()) {
                return this.f70141e.get(i2);
            }
            return null;
        }
        return (d.a.s0.z3.m.e.c.b) invokeI.objValue;
    }

    public final void b(C1922a c1922a, View view, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1922a, view, viewGroup) == null) {
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv_effect);
            c1922a.f70145a = tbImageView;
            tbImageView.setIsRound(true);
            c1922a.f70145a.setDrawerType(1);
            c1922a.f70145a.setDefaultBgResource(R.color.transparent);
            c1922a.f70145a.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            c1922a.f70145a.setConrers(15);
            c1922a.f70145a.setBorderColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0302));
            c1922a.f70147c = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public void c(TbMusicData tbMusicData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMusicData) == null) || getCount() <= 1 || getItem(1) == null || getItem(1).c() != 3) {
            return;
        }
        this.f70143g = 1;
        this.f70142f = TbadkCoreApplication.getInst().getString(R.string.music_cloud);
        notifyDataSetChanged();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f70142f = str;
        }
    }

    public void e(List<d.a.s0.z3.m.e.c.b> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, str) == null) {
            this.f70141e = list;
            this.f70142f = str;
        }
    }

    public void f(RecordEffectLayout.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, iVar) == null) {
            this.f70144h = iVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && getCount() > 1 && getItem(1) != null && getItem(1).c() == 3 && (getItem(1).d() instanceof MusicData)) {
            ((MusicData) getItem(1).d()).img = str;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<d.a.s0.z3.m.e.c.b> list = this.f70141e;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            d.a.s0.z3.m.e.c.b item = getItem(i2);
            if (item == null) {
                return 0;
            }
            int c2 = item.c();
            if (c2 != 1) {
                return c2 != 3 ? 0 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        C1922a c1922a;
        View view2;
        d.a.s0.z3.m.e.c.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                c1922a = new C1922a(this);
                int itemViewType = getItemViewType(i2);
                if (itemViewType == 0) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_effect, (ViewGroup) null);
                    b(c1922a, view2, viewGroup);
                    c1922a.f70146b = (ProgressBar) view2.findViewById(R.id.iv_loading);
                    c1922a.f70147c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType == 1) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_effect, (ViewGroup) null);
                    b(c1922a, view2, viewGroup);
                    c1922a.f70146b = (ProgressBar) view2.findViewById(R.id.iv_loading);
                    c1922a.f70145a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                    c1922a.f70147c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                } else if (itemViewType != 2) {
                    view2 = view;
                } else {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.capture_list_item_beauty, (ViewGroup) null);
                    b(c1922a, view2, viewGroup);
                    c1922a.f70147c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0101));
                }
                view2.setTag(c1922a);
            } else {
                c1922a = (C1922a) view.getTag();
                view2 = view;
            }
            List<d.a.s0.z3.m.e.c.b> list = this.f70141e;
            if (list != null && i2 >= 0 && i2 <= list.size() - 1 && (bVar = this.f70141e.get(i2)) != null) {
                int itemViewType2 = getItemViewType(i2);
                if (itemViewType2 == 0) {
                    QmFilterItem qmFilterItem = (QmFilterItem) bVar.d();
                    if ("-1".equals(qmFilterItem.id)) {
                        TbImageView tbImageView = c1922a.f70145a;
                        String str = qmFilterItem.bgurl;
                        int i3 = f70140i;
                        tbImageView.J(str, 24, i3, i3, false);
                    } else {
                        TbImageView tbImageView2 = c1922a.f70145a;
                        String str2 = qmFilterItem.bgurl;
                        int i4 = f70140i;
                        tbImageView2.J(str2, 10, i4, i4, false);
                    }
                    if (!TextUtils.isEmpty(qmFilterItem.id) && qmFilterItem.id.equals(this.f70142f)) {
                        c1922a.f70145a.setDrawBorder(true);
                    } else {
                        c1922a.f70145a.setDrawBorder(false);
                    }
                    if (qmFilterItem.isDownLoading) {
                        c1922a.f70146b.setVisibility(0);
                    } else {
                        c1922a.f70146b.setVisibility(4);
                    }
                    if (this.f70143g != i2) {
                        c1922a.f70146b.setVisibility(4);
                    } else if (c1922a.f70146b.getVisibility() == 0) {
                        c1922a.f70145a.setDrawBorder(false);
                    }
                    c1922a.f70147c.setText(bVar.b());
                } else if (itemViewType2 == 1) {
                    MusicData musicData = (MusicData) bVar.d();
                    int i5 = musicData.editMusicType;
                    if (i5 != 0 && (i5 != 2 || TextUtils.isEmpty(musicData.img))) {
                        TbImageView tbImageView3 = c1922a.f70145a;
                        String valueOf = String.valueOf(bVar.a());
                        int i6 = f70140i;
                        tbImageView3.J(valueOf, 24, i6, i6, false);
                    } else {
                        TbImageView tbImageView4 = c1922a.f70145a;
                        String str3 = musicData.img;
                        int i7 = f70140i;
                        tbImageView4.J(str3, 10, i7, i7, false);
                    }
                    if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f70142f)) {
                        c1922a.f70145a.setDrawBorder(true);
                    } else {
                        c1922a.f70145a.setDrawBorder(false);
                    }
                    if (this.f70143g != i2) {
                        c1922a.f70146b.setVisibility(4);
                    } else if (c1922a.f70146b.getVisibility() == 0) {
                        c1922a.f70145a.setDrawBorder(false);
                    }
                    c1922a.f70147c.setText(musicData.name);
                } else if (itemViewType2 == 2) {
                    if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f70142f)) {
                        c1922a.f70145a.setBackgroundResource(R.drawable.bg_beauty_item_choosed);
                    } else {
                        c1922a.f70145a.setBackgroundResource(R.drawable.bg_beauty_item);
                    }
                    c1922a.f70147c.setText(bVar.b());
                }
                c1922a.f70145a.setTag(bVar);
                c1922a.f70145a.setTag(R.id.record_video_effect_holder, c1922a);
                c1922a.f70145a.setOnClickListener(this);
                c1922a.f70148d = i2;
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RecordEffectLayout.i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view) == null) && view.getId() == R.id.iv_effect && (view.getTag() instanceof d.a.s0.z3.m.e.c.b)) {
            d.a.s0.z3.m.e.c.b bVar = (d.a.s0.z3.m.e.c.b) view.getTag();
            if (bVar.c() == 3 && (bVar.d() instanceof MusicData)) {
                if (view.getResources().getString(R.string.music_cloud).equals(bVar.b()) && (iVar = this.f70144h) != null) {
                    iVar.b(bVar, view.getTag(R.id.record_video_effect_holder));
                    this.f70143g = this.f70141e.indexOf(bVar);
                    this.f70142f = bVar.b();
                }
                if (!TextUtils.isEmpty(bVar.b()) && bVar.b().equals(this.f70142f)) {
                    return;
                }
                if (!bVar.b().equals(view.getResources().getString(R.string.music_cloud))) {
                    this.f70143g = this.f70141e.indexOf(bVar);
                }
            } else {
                this.f70143g = this.f70141e.indexOf(bVar);
            }
            if (bVar.c() == 2 && (bVar.d() instanceof QmFilterItem)) {
                this.f70142f = ((QmFilterItem) bVar.d()).id;
            } else {
                this.f70142f = bVar.b();
            }
            notifyDataSetChanged();
            RecordEffectLayout.i iVar2 = this.f70144h;
            if (iVar2 != null) {
                iVar2.b(bVar, view.getTag(R.id.record_video_effect_holder));
            }
        }
    }
}
