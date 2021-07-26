package d.a.p0.c0;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Queue<C1181b> f52171a;

    /* renamed from: b  reason: collision with root package name */
    public volatile c f52172b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.p0.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1181b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ImageFileInfo f52173a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.p0.b0.b f52174b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f52175c;

        /* renamed from: d  reason: collision with root package name */
        public d.a.d.k.d.a f52176d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f52177e;

        public C1181b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1181b(b bVar, a aVar) {
            this(bVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<Void, C1181b, C1181b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C1181b> f52178a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f52179b;

        public c(b bVar, Queue<C1181b> queue) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, queue};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52179b = bVar;
            this.f52178a = queue;
            super.setPriority(2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public C1181b doInBackground(Void... voidArr) {
            int i2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (C1181b) invokeL.objValue;
            }
            while (true) {
                C1181b poll = this.f52178a.poll();
                Bitmap bitmap = null;
                if (poll == null) {
                    return null;
                }
                if (isCancelled()) {
                    this.f52178a.add(poll);
                    return null;
                }
                d.a.d.k.d.a m = d.a.p0.b0.c.k().m(poll.f52173a.toCachedKey(poll.f52175c));
                if (m != null) {
                    poll.f52176d = m;
                    poll.f52177e = true;
                } else {
                    Bitmap f2 = this.f52179b.f(poll.f52173a, poll.f52175c);
                    if (f2 != null) {
                        try {
                            i2 = BitmapHelper.readPictureDegree(poll.f52173a.getFilePath());
                            if (i2 != 0) {
                                try {
                                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(f2, i2);
                                    if (f2 != rotateBitmapBydegree) {
                                        try {
                                            f2.recycle();
                                            f2 = null;
                                        } catch (Exception unused) {
                                        }
                                    }
                                    bitmap = rotateBitmapBydegree;
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Exception unused3) {
                            i2 = 0;
                        }
                        if (i2 != 0 && bitmap != null) {
                            poll.f52176d = new d.a.d.k.d.a(bitmap, poll.f52173a.isGif(), poll.f52173a.getFilePath());
                        } else {
                            poll.f52176d = new d.a.d.k.d.a(f2, poll.f52173a.isGif(), poll.f52173a.getFilePath());
                        }
                    }
                }
                publishProgress(poll);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(C1181b c1181b) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1181b) == null) {
                super.onPostExecute(c1181b);
                this.f52179b.f52172b = null;
                this.f52179b.g();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onProgressUpdate(C1181b... c1181bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c1181bArr) == null) || c1181bArr == null) {
                return;
            }
            for (C1181b c1181b : c1181bArr) {
                d.a.d.k.d.a aVar = c1181b.f52176d;
                if (aVar != null && !c1181b.f52177e) {
                    d.a.p0.b0.c.k().d(c1181b.f52173a.toCachedKey(c1181b.f52175c), aVar);
                }
                d.a.p0.b0.b bVar = c1181b.f52174b;
                if (bVar != null) {
                    bVar.a(aVar, c1181b.f52173a.toCachedKey(c1181b.f52175c), c1181b.f52177e);
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048580, this) != null) {
                return;
            }
            super.onCancelled();
            this.f52179b.f52172b = null;
            while (true) {
                C1181b poll = this.f52178a.poll();
                if (poll == null) {
                    return;
                }
                d.a.p0.b0.b bVar = poll.f52174b;
                if (bVar != null) {
                    bVar.a(null, poll.f52173a.toCachedKey(poll.f52175c), false);
                }
            }
        }
    }

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
                return;
            }
        }
        this.f52171a = new ConcurrentLinkedQueue();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f52171a = new ConcurrentLinkedQueue();
            if (this.f52172b != null) {
                this.f52172b.cancel(true);
                this.f52172b = null;
            }
        }
    }

    public d.a.d.k.d.a c(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            return d.a.p0.b0.c.k().m(imageFileInfo.toCachedKey(z));
        }
        return (d.a.d.k.d.a) invokeLZ.objValue;
    }

    public d.a.d.k.d.a d(ImageFileInfo imageFileInfo, d.a.p0.b0.b bVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, imageFileInfo, bVar, z)) == null) ? e(imageFileInfo, bVar, z, false) : (d.a.d.k.d.a) invokeLLZ.objValue;
    }

    public d.a.d.k.d.a e(ImageFileInfo imageFileInfo, d.a.p0.b0.b bVar, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{imageFileInfo, bVar, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            d.a.d.k.d.a c2 = c(imageFileInfo, z);
            if (c2 != null) {
                return c2;
            }
            if (z2) {
                return null;
            }
            C1181b c1181b = new C1181b(this, null);
            c1181b.f52174b = bVar;
            c1181b.f52173a = imageFileInfo;
            c1181b.f52175c = z;
            this.f52171a.add(c1181b);
            g();
            return null;
        }
        return (d.a.d.k.d.a) invokeCommon.objValue;
    }

    public Bitmap f(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, imageFileInfo, z)) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            if (z && imageFileInfo.getPersistActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPersistActionsList());
            }
            if (imageFileInfo.getPageActionsList() != null) {
                linkedList.addAll(imageFileInfo.getPageActionsList());
            }
            if (imageFileInfo.getOrginalBitmap() != null) {
                try {
                    return d.a.p0.c0.g.c.d().b(imageFileInfo.getOrginalBitmap(), !imageFileInfo.isOrginalBitmapShared(), linkedList, imageFileInfo);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            } else if (imageFileInfo.hasActions(z)) {
                try {
                    return d.a.p0.c0.g.c.d().c(imageFileInfo.getFilePath(), linkedList, imageFileInfo);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return null;
                }
            } else {
                return BitmapHelper.loadBitmap(imageFileInfo.getFilePath());
            }
        }
        return (Bitmap) invokeLZ.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f52172b == null && !this.f52171a.isEmpty()) {
            this.f52172b = new c(this, this.f52171a);
            this.f52172b.execute(new Void[0]);
        }
    }
}
