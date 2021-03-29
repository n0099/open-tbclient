package d.b.d0.b.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes2.dex */
public abstract class f implements IBinder, IBinder.DeathRecipient {

    /* renamed from: e  reason: collision with root package name */
    public volatile IBinder f42719e;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<IBinder.DeathRecipient> f42720f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    public Object f42721g = new Object();

    public static void b(String str, Exception exc) {
    }

    public final IBinder a() throws RemoteException {
        synchronized (this.f42721g) {
            IBinder iBinder = this.f42719e;
            if (iBinder != null) {
                return iBinder;
            }
            IBinder c2 = c();
            this.f42719e = c2;
            if (c2 != null) {
                c2.linkToDeath(this, 0);
                return c2;
            }
            throw new RemoteException();
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        synchronized (this.f42721g) {
            IBinder iBinder = this.f42719e;
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
                this.f42719e = null;
            }
            ArrayList<IBinder.DeathRecipient> arrayList = new ArrayList();
            synchronized (this.f42720f) {
                arrayList.addAll(this.f42720f);
            }
            for (IBinder.DeathRecipient deathRecipient : arrayList) {
                deathRecipient.binderDied();
            }
        }
    }

    public abstract IBinder c() throws RemoteException;

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        a().dump(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
        a().dumpAsync(fileDescriptor, strArr);
    }

    @Override // android.os.IBinder
    public String getInterfaceDescriptor() throws RemoteException {
        return a().getInterfaceDescriptor();
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        try {
            return a().isBinderAlive();
        } catch (RemoteException e2) {
            b("MultiProcess", e2);
            return false;
        }
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
        synchronized (this.f42720f) {
            this.f42720f.add(deathRecipient);
        }
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        try {
            return a().pingBinder();
        } catch (RemoteException e2) {
            b("MultiProcess", e2);
            return false;
        }
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        try {
            return a().queryLocalInterface(str);
        } catch (RemoteException e2) {
            b("MultiProcess", e2);
            return null;
        }
    }

    @Override // android.os.IBinder
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return a().transact(i, parcel, parcel2, i2);
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        synchronized (this.f42720f) {
            this.f42720f.remove(deathRecipient);
        }
        return this.f42719e != null;
    }
}
