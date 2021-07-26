package d.a.q0.p0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<CollectEmotionData> f61770e;

    /* renamed from: f  reason: collision with root package name */
    public List<CollectEmotionData> f61771f;

    /* renamed from: g  reason: collision with root package name */
    public int f61772g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.c0.b f61773h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f61774i;
    public int j;
    public e k;
    public InterfaceC1590d l;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f61775e;

        public a(d dVar, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61775e = viewGroup;
        }

        @Override // d.a.p0.b0.b
        public void a(d.a.d.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f61775e.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f61776e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f61777f;

        public b(d dVar, int i2) {
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
            this.f61777f = dVar;
            this.f61776e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CollectEmotionData item;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f61777f.f61774i && (item = this.f61777f.getItem(this.f61776e)) != null) {
                if (!this.f61777f.f61771f.contains(item)) {
                    item.selectIndex = this.f61777f.f61771f.size() + 1;
                    item.isSelect = true;
                    this.f61777f.f61771f.add(item);
                } else {
                    item.selectIndex = -1;
                    int i2 = 0;
                    item.isSelect = false;
                    this.f61777f.f61771f.remove(item);
                    while (i2 < this.f61777f.f61771f.size()) {
                        i2++;
                        this.f61777f.getItem(this.f61776e).selectIndex = i2;
                    }
                }
                if (view.getId() == R.id.collect_select_icon) {
                    imageView = (ImageView) view;
                } else {
                    imageView = (ImageView) ((RelativeLayout) view.getParent()).findViewById(R.id.collect_select_icon);
                }
                if (imageView != null) {
                    if (item.isSelect) {
                        SkinManager.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_s);
                    } else {
                        SkinManager.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_n);
                    }
                }
                if (this.f61777f.k != null) {
                    this.f61777f.k.b(this.f61777f.f61771f);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f61778e;

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
            this.f61778e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f61778e.l == null) {
                return;
            }
            this.f61778e.l.e();
        }
    }

    /* renamed from: d.a.q0.p0.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1590d {
        void e();
    }

    /* loaded from: classes8.dex */
    public interface e {
        void b(List<CollectEmotionData> list);
    }

    /* loaded from: classes8.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f61779a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61780b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61781c;

        public f(d dVar) {
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

        public /* synthetic */ f(d dVar, a aVar) {
            this(dVar);
        }
    }

    public d(InterfaceC1590d interfaceC1590d) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interfaceC1590d};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61770e = new ArrayList();
        this.f61771f = new ArrayList();
        this.l = interfaceC1590d;
        this.f61772g = d.a.d.e.p.l.k(TbadkCoreApplication.getInst()) / 4;
        this.f61773h = new d.a.p0.c0.b();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f61774i) {
            for (CollectEmotionData collectEmotionData : this.f61771f) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.f61771f.clear();
            ArrayList arrayList = new ArrayList(this.f61770e);
            this.f61770e.clear();
            this.f61770e.addAll(arrayList);
            notifyDataSetChanged();
            e eVar = this.k;
            if (eVar != null) {
                eVar.b(this.f61771f);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public CollectEmotionData getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 == 0) {
                return null;
            }
            return (CollectEmotionData) ListUtils.getItem(this.f61770e, i2 - 1);
        }
        return (CollectEmotionData) invokeI.objValue;
    }

    public List<CollectEmotionData> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61771f : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61770e.size() + 1 : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 == 0 ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        View view2;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (view == null) {
                    fVar = new f(this, null);
                    view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                    fVar.f61779a = view;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = this.f61772g;
                    fVar.f61779a.setLayoutParams(layoutParams);
                    TbImageView tbImageView = (TbImageView) view.findViewById(R.id.collect_pic);
                    fVar.f61780b = tbImageView;
                    ((RelativeLayout.LayoutParams) tbImageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                    fVar.f61780b.setScaleType(ImageView.ScaleType.CENTER);
                    view.findViewById(R.id.collect_select_icon).setVisibility(8);
                    view.setTag(fVar);
                    SkinManager.setBackgroundColor(view, R.color.white_alpha0, this.j);
                } else {
                    fVar = (f) view.getTag();
                }
                if (this.f61774i) {
                    fVar.f61779a.setEnabled(false);
                    SkinManager.setImageResource(fVar.f61780b, R.drawable.icon_emotion_unplusadd_n);
                } else {
                    fVar.f61779a.setEnabled(true);
                    SkinManager.setImageResource(fVar.f61780b, R.drawable.icon_emotion_plusadd_n);
                }
                fVar.f61779a.setOnClickListener(new c(this));
                return view;
            } else if (itemViewType != 1) {
                return view;
            } else {
                if (view == null) {
                    fVar2 = new f(this, null);
                    view2 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                    fVar2.f61779a = view2;
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    layoutParams2.height = this.f61772g;
                    fVar2.f61779a.setLayoutParams(layoutParams2);
                    fVar2.f61780b = (TbImageView) view2.findViewById(R.id.collect_pic);
                    fVar2.f61781c = (ImageView) view2.findViewById(R.id.collect_select_icon);
                    view2.setTag(fVar2);
                    SkinManager.setBackgroundColor(view2, R.color.CAM_X0201, this.j);
                } else {
                    view2 = view;
                    fVar2 = (f) view.getTag();
                }
                fVar2.f61780b.setTag(null);
                fVar2.f61780b.setDefaultResource(R.drawable.img_default_100);
                fVar2.f61780b.M(null, 12, false);
                fVar2.f61780b.invalidate();
                SkinManager.setBackgroundResource(fVar2.f61780b, R.drawable.btn_choose_face_selector, this.j);
                ImageFileInfo imageFileInfo = getItem(i2).imageFileInfo;
                if (imageFileInfo != null) {
                    imageFileInfo.clearPageActions();
                    int i3 = this.f61772g;
                    imageFileInfo.addPageAction(d.a.p0.c0.g.d.g(i3, i3));
                    fVar2.f61780b.setTag(imageFileInfo.toCachedKey(false));
                    if (this.f61773h.c(imageFileInfo, false) != null) {
                        fVar2.f61780b.invalidate();
                    } else {
                        this.f61773h.e(imageFileInfo, new a(this, viewGroup), false, false);
                    }
                }
                if (this.f61774i) {
                    fVar2.f61781c.setVisibility(0);
                } else {
                    fVar2.f61781c.setVisibility(8);
                }
                if (this.f61771f.contains(getItem(i2))) {
                    SkinManager.setBackgroundResource(fVar2.f61781c, R.drawable.ic_post_image_selected_s);
                } else {
                    SkinManager.setBackgroundResource(fVar2.f61781c, R.drawable.ic_post_image_selected_n);
                }
                b bVar = new b(this, i2);
                fVar2.f61780b.setOnClickListener(bVar);
                fVar2.f61781c.setOnClickListener(bVar);
                return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void h(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.k = eVar;
        }
    }

    public void i(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.f61770e.clear();
            if (list == null) {
                return;
            }
            this.f61770e.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.f61774i == z) {
            return;
        }
        for (CollectEmotionData collectEmotionData : this.f61771f) {
            collectEmotionData.isSelect = false;
            collectEmotionData.selectIndex = -1;
        }
        this.f61771f.clear();
        this.f61774i = z;
        ArrayList arrayList = new ArrayList(this.f61770e);
        this.f61770e.clear();
        this.f61770e.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.j = i2;
        }
    }
}
