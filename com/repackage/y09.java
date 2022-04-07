package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class y09 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ImageFileInfo> a;
    public Context b;
    public k35 c;
    public v05 d;
    public f e;
    public LayoutInflater f;
    public boolean g;
    public boolean h;
    public int i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y09 a;

        public a(y09 y09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y09Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 13));
            this.a.e.b();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ y09 b;

        public b(y09 y09Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y09Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y09Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (i = this.a) < 0) {
                return;
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.b.getItem(i);
            if (imageFileInfo.isFromMoreForum) {
                return;
            }
            boolean z = true;
            if (imageFileInfo == null || (imageFileInfo.getImageType() != 1 && !new File(imageFileInfo.getFilePath()).exists())) {
                z = false;
            }
            if (!z) {
                oi.J(this.b.b, R.string.obfuscated_res_0x7f0f0526);
                return;
            }
            if (this.b.d != null) {
                this.b.d.d(new i05(15, 0, Integer.valueOf(this.a)));
            }
            if (this.b.e != null) {
                this.b.e.c(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ y09 b;

        public c(y09 y09Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y09Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y09Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.e == null) {
                return;
            }
            this.b.e.a(this.a);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements g35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public d(y09 y09Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y09Var, viewGroup};
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

        @Override // com.repackage.g35
        public void a(fo foVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, foVar, str, z) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(str)) == null || foVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes7.dex */
    public class e extends hg<fo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ String b;

        public e(y09 y09Var, ViewGroup viewGroup, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y09Var, viewGroup, str};
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
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048576, this, foVar, str, i) == null) || (tbImageView = (TbImageView) this.a.findViewWithTag(this.b)) == null || foVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes7.dex */
    public interface f {
        void a(int i);

        void b();

        void c(int i);
    }

    public y09(Context context, k35 k35Var, v05 v05Var, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, k35Var, v05Var, fVar};
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
        this.g = false;
        this.h = false;
        this.d = v05Var;
        this.b = context;
        this.f = LayoutInflater.from(context);
        this.c = k35Var;
        this.e = fVar;
    }

    public final String d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.b.getResources().getString(i) : (String) invokeI.objValue;
    }

    public final void e(ImageFileInfo imageFileInfo, View view2, ViewGroup viewGroup, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{imageFileInfo, view2, viewGroup, Integer.valueOf(i), Integer.valueOf(i2)}) == null) || imageFileInfo == null || i <= 0 || i2 <= 0) {
            return;
        }
        ImageOperation g = u35.g(i, i2);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(g);
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fb2);
        ((FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f96)).setForeground(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080e27));
        if (imageFileInfo.getImageType() == 0) {
            fo c2 = this.c.c(imageFileInfo, true);
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (c2 != null) {
                tbImageView.invalidate();
            } else {
                this.c.d(imageFileInfo, new d(this, viewGroup), true);
            }
            tbImageView.setTagStr(this.b.getString(R.string.obfuscated_res_0x7f0f0513));
        } else if (imageFileInfo.getImageType() == 1) {
            String filePath = imageFileInfo.getFilePath();
            if (!ni.isEmpty(filePath) && filePath.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                String g2 = ig.h().g(filePath, 20);
                tbImageView.setTag(g2);
                ig.h().k(filePath, 20, new e(this, viewGroup, g2), 0, 0, null, null, filePath, Boolean.FALSE, null);
            }
            tbImageView.setTagStr("");
        }
    }

    public void f(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeImagesInfo) == null) || writeImagesInfo == null) {
            return;
        }
        this.i = writeImagesInfo.getMaxImagesAllowed();
        int count = ListUtils.getCount(writeImagesInfo.getChosedFiles());
        this.a.clear();
        if (count > 0) {
            this.a.addAll(writeImagesInfo.getChosedFiles());
        }
        if (count >= this.i || !this.g || !this.h || count <= 0) {
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath("FLAG_ADD_ICON");
        this.a.add(imageFileInfo);
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.g = z;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.a.get(i) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        AbsListView.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            ImageFileInfo imageFileInfo = (ImageFileInfo) ListUtils.getItem(this.a, i);
            if (imageFileInfo == null) {
                return null;
            }
            if (view2 == null) {
                view2 = this.f.inflate(R.layout.obfuscated_res_0x7f0d05f6, (ViewGroup) null);
            }
            int k = (oi.k(this.b) - ((oi.f(this.b, R.dimen.tbds44) * 2) + (oi.f(this.b, R.dimen.tbds10) * 2))) / 3;
            if (view2.getLayoutParams() instanceof AbsListView.LayoutParams) {
                layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
                layoutParams.width = k;
                layoutParams.height = k;
            } else {
                layoutParams = new AbsListView.LayoutParams(k, k);
            }
            view2.setLayoutParams(layoutParams);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fb2);
            tbImageView.setTagTextSize(oi.f(this.b, R.dimen.T_X10));
            tbImageView.setDrawBorder(true);
            tbImageView.setDrawCorner(true);
            tbImageView.setAutoChangeStyle(true);
            tbImageView.setConrers(15);
            tbImageView.setRadiusById(R.string.J_X05);
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09077b);
            ((ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090776)).setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080813, WebPManager.ResourceStateType.NORMAL));
            FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f96);
            if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
                tbImageView.setVisibility(8);
                linearLayout.setVisibility(8);
                view2.setBackgroundDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08095b, WebPManager.ResourceStateType.NORMAL_PRESS));
                view2.invalidate();
                frameLayout.setForeground(null);
                view2.setOnClickListener(new a(this));
            } else {
                tbImageView.setVisibility(0);
                linearLayout.setVisibility(0);
                view2.setBackgroundResource(0);
                tbImageView.setGifIconSupport(true);
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(imageFileInfo.isLong());
                tbImageView.setTagStr(d(R.string.obfuscated_res_0x7f0f0513));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    tbImageView.setTagColor(this.b.getResources().getColor(R.color.CAM_X0101));
                } else {
                    tbImageView.setTagColor(this.b.getResources().getColor(R.color.CAM_X0101));
                }
                e(imageFileInfo, view2, viewGroup, k, k);
                if (imageFileInfo.isFromMoreForum) {
                    linearLayout.setVisibility(8);
                    tbImageView.setTagStr("");
                }
                view2.setOnClickListener(new b(this, i));
                linearLayout.setOnClickListener(new c(this, i));
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.g = true;
            this.h = z;
        }
    }
}
