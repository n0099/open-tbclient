package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class pz8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public b45 b;
    public EditorTools c;
    public int d;
    public int e;
    public BaseActivity f;
    public LinkedList<ImageFileInfo> g;
    public GridView h;
    public e i;

    /* loaded from: classes6.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz8 a;

        public a(pz8 pz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz8Var;
        }

        @Override // com.repackage.pz8.e
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.g == null) {
                return;
            }
            if (this.a.g.size() - 1 >= i) {
                ImageFileInfo imageFileInfo = (ImageFileInfo) this.a.g.remove(i);
                if (imageFileInfo.isTempFile()) {
                    rb.f().a(new DiskFileOperate(imageFileInfo.getFilePath(), null, DiskFileOperate.Action.DELETE));
                }
            }
            int size = this.a.g.size();
            if (this.a.c != null) {
                this.a.c.A(new w05(this.a.d, -1, null));
                if (size > 0) {
                    this.a.c.A(new w05(2, 10, String.valueOf(size)));
                } else {
                    this.a.c.A(new w05(2, 10, null));
                }
                if (this.a.g.size() == 1 && size == 0) {
                    this.a.c.A(new w05(1, 2, null));
                }
            }
            this.a.k();
            ((WriteActivity) this.a.f).updateChoseFile(this.a.g);
            this.a.h();
            this.a.notifyDataSetChanged();
            this.a.h.invalidateViews();
        }
    }

    /* loaded from: classes6.dex */
    public class b implements x35 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        public b(pz8 pz8Var, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz8Var, viewGroup};
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

        @Override // com.repackage.x35
        public void a(co coVar, String str, boolean z) {
            ViewGroup viewGroup;
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, coVar, str, z) == null) || (viewGroup = this.a) == null || (tbImageView = (TbImageView) viewGroup.findViewWithTag(str)) == null || coVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ pz8 c;

        public c(pz8 pz8Var, ViewGroup viewGroup, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz8Var, viewGroup, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pz8Var;
            this.a = viewGroup;
            this.b = z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
            if (r3.length() != 0) goto L20;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view2) {
            int indexOfChild;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (indexOfChild = this.a.indexOfChild(view2)) < 0) {
                return;
            }
            boolean z = true;
            if (this.b && (this.c.f instanceof WriteActivity)) {
                if (this.c.g != null && this.c.g.size() > 0) {
                    this.c.g.remove(this.c.g.size() - 1);
                }
                ((WriteActivity) this.c.f).updateChoseFile(this.c.g);
                ((WriteActivity) this.c.f).openImageActivity(null);
                return;
            }
            ImageFileInfo imageFileInfo = (ImageFileInfo) this.c.getItem(indexOfChild);
            if (imageFileInfo != null) {
                File file = new File(imageFileInfo.getFilePath());
                if (file.exists()) {
                }
            }
            z = false;
            if (!z) {
                mi.J(this.c.a, R.string.obfuscated_res_0x7f0f052c);
            } else if (this.c.c != null) {
                if (this.c.j()) {
                    this.c.k();
                }
                ((WriteActivity) this.c.f).updateChoseFile(this.c.g);
                this.c.c.A(new w05(15, 0, Integer.valueOf(indexOfChild)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ pz8 b;

        public d(pz8 pz8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pz8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pz8Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.i == null) {
                return;
            }
            this.b.i.a(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public interface e {
        void a(int i);
    }

    public pz8(BaseActivity baseActivity, WriteImagesInfo writeImagesInfo, GridView gridView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, writeImagesInfo, gridView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new b45();
        this.c = null;
        this.d = 13;
        this.e = 6;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = new a(this);
        this.f = baseActivity;
        this.a = baseActivity.getActivity();
        this.h = gridView;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.g;
            if (linkedList == null) {
                return 0;
            }
            return linkedList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.g;
            if (linkedList == null) {
                return null;
            }
            if (linkedList.size() - 1 >= i) {
                return this.g.get(i);
            }
            return 0;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b45 b45Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, view2, viewGroup)) == null) {
            boolean z = false;
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06d7, viewGroup, false);
            LinkedList<ImageFileInfo> linkedList = this.g;
            co coVar = null;
            ImageFileInfo imageFileInfo = (linkedList == null || linkedList.size() - 1 < i) ? null : this.g.get(i);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f090fa5);
            FrameLayout frameLayout = (FrameLayout) findViewById.findViewById(R.id.obfuscated_res_0x7f091cee);
            TbImageView tbImageView = (TbImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f090ff4);
            ImageView imageView = (ImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f09077a);
            String filePath = imageFileInfo != null ? imageFileInfo.getFilePath() : "";
            LinkedList<ImageFileInfo> linkedList2 = this.g;
            if (linkedList2 != null && i == linkedList2.size() - 1 && filePath.startsWith("android.resource://")) {
                z = true;
            }
            if (z) {
                imageView.setVisibility(8);
                SkinManager.setImageResource(tbImageView, R.drawable.btn_addpic_n);
            } else {
                SkinManager.setImageResource(imageView, R.drawable.obfuscated_res_0x7f08078e);
            }
            frameLayout.setForeground(SkinManager.getDrawable(R.drawable.bg_add_photo_foregroundselector));
            int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070273);
            ImageOperation g = l45.g(dimensionPixelSize, dimensionPixelSize);
            if (imageFileInfo != null) {
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(g);
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
            }
            b bVar = new b(this, viewGroup);
            if (imageFileInfo != null && (b45Var = this.b) != null) {
                coVar = b45Var.d(imageFileInfo, bVar, true);
            }
            if (coVar != null) {
                tbImageView.invalidate();
            }
            inflate.setOnClickListener(new c(this, viewGroup, z));
            imageView.setOnClickListener(new d(this, i));
            return inflate;
        }
        return (View) invokeILL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            LinkedList<ImageFileInfo> linkedList = this.g;
            if (linkedList != null && linkedList.size() != 0) {
                if (this.g.size() >= this.e) {
                    return;
                }
                if (this.g.size() > 0) {
                    LinkedList<ImageFileInfo> linkedList2 = this.g;
                    if (linkedList2.get(linkedList2.size() - 1).getFilePath().startsWith("android.resource://")) {
                        return;
                    }
                }
                i();
                return;
            }
            i();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath("android.resource://" + this.a.getPackageName() + "/" + R.drawable.btn_addpic_n);
            imageFileInfo.setTempFile(true);
            if (this.g == null) {
                this.g = new LinkedList<>();
            }
            this.g.add(imageFileInfo);
            notifyDataSetChanged();
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            LinkedList<ImageFileInfo> linkedList = this.g;
            if (linkedList != null && linkedList.size() != 0) {
                LinkedList<ImageFileInfo> linkedList2 = this.g;
                if (linkedList2.get(linkedList2.size() - 1).getFilePath().startsWith("android.resource://")) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        LinkedList<ImageFileInfo> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (linkedList = this.g) == null || linkedList.size() <= 0) {
            return;
        }
        int size = this.g.size() - 1;
        if (this.g.get(size).getFilePath().startsWith("android.resource://")) {
            this.g.remove(size);
        }
    }

    public void l(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, writeImagesInfo) == null) {
            if (writeImagesInfo == null) {
                writeImagesInfo = new WriteImagesInfo();
            }
            if (this.g == null) {
                this.g = new LinkedList<>();
            }
            this.g.clear();
            if (writeImagesInfo.getChosedFiles() != null && writeImagesInfo.size() > 0) {
                this.g.addAll(writeImagesInfo.getChosedFiles());
            }
            h();
            notifyDataSetInvalidated();
        }
    }

    public void m(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, editorTools) == null) {
            this.c = editorTools;
        }
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.e = i;
        }
    }
}
