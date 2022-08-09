package com.repackage;

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
/* loaded from: classes6.dex */
public class la6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<CollectEmotionData> a;
    public List<CollectEmotionData> b;
    public int c;
    public l55 d;
    public boolean e;
    public int f;
    public e g;
    public d h;

    /* loaded from: classes6.dex */
    public class a implements h55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public a(la6 la6Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
        }

        @Override // com.repackage.h55
        public void a(zm zmVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, zmVar, str, z) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(str)) == null || zmVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ la6 b;

        public b(la6 la6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = la6Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            CollectEmotionData item;
            ImageView imageView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.e && (item = this.b.getItem(this.a)) != null) {
                if (!this.b.b.contains(item)) {
                    item.selectIndex = this.b.b.size() + 1;
                    item.isSelect = true;
                    this.b.b.add(item);
                } else {
                    item.selectIndex = -1;
                    int i = 0;
                    item.isSelect = false;
                    this.b.b.remove(item);
                    while (i < this.b.b.size()) {
                        i++;
                        this.b.getItem(this.a).selectIndex = i;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f090661) {
                    imageView = (ImageView) view2;
                } else {
                    imageView = (ImageView) ((RelativeLayout) view2.getParent()).findViewById(R.id.obfuscated_res_0x7f090661);
                }
                if (imageView != null) {
                    if (item.isSelect) {
                        SkinManager.setBackgroundResource(imageView, R.drawable.obfuscated_res_0x7f080643);
                    } else {
                        SkinManager.setBackgroundResource(imageView, R.drawable.obfuscated_res_0x7f080642);
                    }
                }
                if (this.b.g != null) {
                    this.b.g.z(this.b.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la6 a;

        public c(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.h == null) {
                return;
            }
            this.a.h.j1();
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        void j1();
    }

    /* loaded from: classes6.dex */
    public interface e {
        void z(List<CollectEmotionData> list);
    }

    /* loaded from: classes6.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TbImageView b;
        public ImageView c;

        public f(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(la6 la6Var, a aVar) {
            this(la6Var);
        }
    }

    public la6(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.h = dVar;
        this.c = qi.k(TbadkCoreApplication.getInst()) / 4;
        this.d = new l55();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.e) {
            for (CollectEmotionData collectEmotionData : this.b) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.b.clear();
            ArrayList arrayList = new ArrayList(this.a);
            this.a.clear();
            this.a.addAll(arrayList);
            notifyDataSetChanged();
            e eVar = this.g;
            if (eVar != null) {
                eVar.z(this.b);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public CollectEmotionData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i == 0) {
                return null;
            }
            return (CollectEmotionData) ListUtils.getItem(this.a, i - 1);
        }
        return (CollectEmotionData) invokeI.objValue;
    }

    public List<CollectEmotionData> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.size() + 1 : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i == 0 ? 0 : 1 : invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        View view3;
        f fVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (view2 == null) {
                    fVar = new f(this, null);
                    view2 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d01de, viewGroup, false);
                    fVar.a = view2;
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    layoutParams.height = this.c;
                    fVar.a.setLayoutParams(layoutParams);
                    TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090660);
                    fVar.b = tbImageView;
                    ((RelativeLayout.LayoutParams) tbImageView.getLayoutParams()).setMargins(0, 0, 0, 0);
                    fVar.b.setScaleType(ImageView.ScaleType.CENTER);
                    view2.findViewById(R.id.obfuscated_res_0x7f090661).setVisibility(8);
                    view2.setTag(fVar);
                    SkinManager.setBackgroundColor(view2, R.color.white_alpha0, this.f);
                } else {
                    fVar = (f) view2.getTag();
                }
                if (this.e) {
                    fVar.a.setEnabled(false);
                    SkinManager.setImageResource(fVar.b, R.drawable.icon_emotion_unplusadd_n);
                } else {
                    fVar.a.setEnabled(true);
                    SkinManager.setImageResource(fVar.b, R.drawable.icon_emotion_plusadd_n);
                }
                fVar.a.setOnClickListener(new c(this));
                return view2;
            } else if (itemViewType != 1) {
                return view2;
            } else {
                if (view2 == null) {
                    fVar2 = new f(this, null);
                    view3 = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.obfuscated_res_0x7f0d01de, viewGroup, false);
                    fVar2.a = view3;
                    ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
                    layoutParams2.height = this.c;
                    fVar2.a.setLayoutParams(layoutParams2);
                    fVar2.b = (TbImageView) view3.findViewById(R.id.obfuscated_res_0x7f090660);
                    fVar2.c = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090661);
                    view3.setTag(fVar2);
                    SkinManager.setBackgroundColor(view3, R.color.CAM_X0201, this.f);
                } else {
                    view3 = view2;
                    fVar2 = (f) view2.getTag();
                }
                fVar2.b.setTag(null);
                fVar2.b.setDefaultResource(R.drawable.obfuscated_res_0x7f080bc1);
                fVar2.b.K(null, 12, false);
                fVar2.b.invalidate();
                SkinManager.setBackgroundResource(fVar2.b, R.drawable.btn_choose_face_selector, this.f);
                ImageFileInfo imageFileInfo = getItem(i).imageFileInfo;
                if (imageFileInfo != null) {
                    imageFileInfo.clearPageActions();
                    int i2 = this.c;
                    imageFileInfo.addPageAction(u55.g(i2, i2));
                    fVar2.b.setTag(imageFileInfo.toCachedKey(false));
                    if (this.d.c(imageFileInfo, false) != null) {
                        fVar2.b.invalidate();
                    } else {
                        this.d.e(imageFileInfo, new a(this, viewGroup), false, false);
                    }
                }
                if (this.e) {
                    fVar2.c.setVisibility(0);
                } else {
                    fVar2.c.setVisibility(8);
                }
                if (this.b.contains(getItem(i))) {
                    SkinManager.setBackgroundResource(fVar2.c, R.drawable.obfuscated_res_0x7f080643);
                } else {
                    SkinManager.setBackgroundResource(fVar2.c, R.drawable.obfuscated_res_0x7f080642);
                }
                b bVar = new b(this, i);
                fVar2.b.setOnClickListener(bVar);
                fVar2.c.setOnClickListener(bVar);
                return view3;
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
            this.g = eVar;
        }
    }

    public void i(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.a.clear();
            if (list == null) {
                return;
            }
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || this.e == z) {
            return;
        }
        for (CollectEmotionData collectEmotionData : this.b) {
            collectEmotionData.isSelect = false;
            collectEmotionData.selectIndex = -1;
        }
        this.b.clear();
        this.e = z;
        ArrayList arrayList = new ArrayList(this.a);
        this.a.clear();
        this.a.addAll(arrayList);
        notifyDataSetChanged();
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f = i;
        }
    }
}
