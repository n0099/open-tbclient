package d.a.q0.e0;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.l;
import d.a.q0.e0.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class f implements c.a {
    public static /* synthetic */ Interceptable $ic;
    public static f j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f55588a;

    /* renamed from: b  reason: collision with root package name */
    public c f55589b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<TransmitForumData> f55590c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<TransmitForumData> f55591d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f55592e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<TransmitForumData> f55593f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55594g;

    /* renamed from: h  reason: collision with root package name */
    public int f55595h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55596i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(169155406, "Ld/a/q0/e0/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(169155406, "Ld/a/q0/e0/f;");
        }
    }

    public f() {
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
        this.f55590c = new ArrayList<>();
        this.f55592e = false;
        this.f55594g = false;
        this.f55596i = false;
        d();
    }

    public static f b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (j == null) {
                synchronized (f.class) {
                    if (j == null) {
                        j = new f();
                    }
                }
            }
            return j;
        }
        return (f) invokeV.objValue;
    }

    @Override // d.a.q0.e0.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{arrayList, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (i2 == 1) {
                if (z) {
                    this.f55593f = arrayList;
                }
                this.f55594g = true;
            } else if (i2 == 2) {
                if (z) {
                    this.f55591d = arrayList;
                    this.f55595h = i3;
                }
                this.f55592e = true;
            }
            i();
        }
    }

    public final Location c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (PermissionUtil.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
                LocationManager locationManager = (LocationManager) TbadkCoreApplication.getInst().getSystemService("location");
                Criteria criteria = new Criteria();
                criteria.setAccuracy(1);
                criteria.setAltitudeRequired(false);
                criteria.setBearingRequired(false);
                criteria.setCostAllowed(true);
                criteria.setPowerRequirement(1);
                try {
                    return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return (Location) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            f();
            e();
            this.f55596i = false;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), c.class);
            if (runTask != null) {
                this.f55589b = (c) runTask.getData();
            }
            c cVar = this.f55589b;
            if (cVar != null) {
                cVar.a(this);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), c.class);
            if (runTask != null) {
                this.f55588a = (c) runTask.getData();
            }
            c cVar = this.f55588a;
            if (cVar != null) {
                cVar.a(this);
            }
        }
    }

    public final boolean g(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            ArrayList<TransmitForumData> arrayList = this.f55590c;
            if (arrayList == null) {
                return false;
            }
            Iterator<TransmitForumData> it = arrayList.iterator();
            while (it.hasNext()) {
                TransmitForumData next = it.next();
                if (next != null && next.forumId == j2) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f55596i = true;
            c cVar = this.f55588a;
            if (cVar != null) {
                cVar.b();
            }
            c cVar2 = this.f55589b;
            if (cVar2 != null) {
                cVar2.b();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f55588a == null || this.f55592e) {
                if (this.f55589b == null || this.f55594g) {
                    this.f55592e = false;
                    this.f55594g = false;
                    this.f55596i = false;
                    this.f55590c.clear();
                    if (!ListUtils.isEmpty(this.f55591d)) {
                        Iterator<TransmitForumData> it = this.f55591d.iterator();
                        while (it.hasNext()) {
                            TransmitForumData next = it.next();
                            if (!g(next.forumId)) {
                                this.f55590c.add(next);
                            }
                        }
                    }
                    if (!ListUtils.isEmpty(this.f55593f)) {
                        Iterator<TransmitForumData> it2 = this.f55593f.iterator();
                        while (it2.hasNext()) {
                            TransmitForumData next2 = it2.next();
                            if (!g(next2.forumId)) {
                                this.f55590c.add(next2);
                            }
                        }
                    }
                    this.f55591d = null;
                    this.f55593f = null;
                    j();
                }
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.f55590c));
        }
    }

    public void k(ShareDialogConfig shareDialogConfig) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, shareDialogConfig) == null) || shareDialogConfig == null || shareDialogConfig.shareItem == null || l.a()) {
            return;
        }
        if (shareDialogConfig.showLocation) {
            shareDialogConfig.shareItem.B = c();
        }
        if (d.a.d.e.p.l.D() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.f55596i && !shareDialogConfig.shareItem.f()) {
            h();
        }
        shareDialogConfig.setIsShowTransmitShare(true);
        shareDialogConfig.setTransmitForumList(this.f55590c);
        shareDialogConfig.setPrivateThread(this.f55595h);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
