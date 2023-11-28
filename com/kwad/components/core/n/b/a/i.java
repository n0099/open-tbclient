package com.kwad.components.core.n.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.network.INetworkChangeListener;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bn;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class i implements INetworkManager {
    public List<INetworkChangeListener> MJ = new CopyOnWriteArrayList();
    public NetworkMonitor.a MK;

    private void ad(final Context context) {
        if (this.MK != null) {
            return;
        }
        this.MK = new NetworkMonitor.a() { // from class: com.kwad.components.core.n.b.a.i.1
            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public final void a(NetworkMonitor.NetworkState networkState) {
                bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.n.b.a.i.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        int networkType = i.this.getNetworkType(context);
                        for (INetworkChangeListener iNetworkChangeListener : i.this.MJ) {
                            iNetworkChangeListener.networkChange(networkType);
                        }
                    }
                });
            }
        };
        NetworkMonitor.getInstance().a(context, this.MK);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final int getNetworkType(Context context) {
        return ag.ck(context);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        if (iNetworkChangeListener != null) {
            ad(context);
            this.MJ.add(iNetworkChangeListener);
        }
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        this.MJ.remove(iNetworkChangeListener);
    }
}
