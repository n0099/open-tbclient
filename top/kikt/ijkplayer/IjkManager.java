package top.kikt.ijkplayer;

import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class IjkManager {
    private HashMap<Long, Object> ijkListMap = new HashMap<>();
    private PluginRegistry.Registrar registrar;

    public IjkManager(PluginRegistry.Registrar registrar) {
        this.registrar = registrar;
    }

    public Ijk create(Map map) {
        Ijk ijk = new Ijk(this.registrar, map);
        this.ijkListMap.put(Long.valueOf(ijk.getId()), ijk);
        return ijk;
    }

    private Ijk findIJK(long j) {
        return (Ijk) this.ijkListMap.get(Long.valueOf(j));
    }

    public void dispose(long j) {
        Ijk findIJK = findIJK(j);
        if (findIJK != null) {
            this.ijkListMap.remove(Long.valueOf(j));
            findIJK.dispose();
        }
    }

    public void disposeAll() {
        for (Map.Entry<Long, Object> entry : this.ijkListMap.entrySet()) {
            ((Ijk) entry.getValue()).dispose();
        }
        this.ijkListMap.clear();
    }
}
