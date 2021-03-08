package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.util.Path;
import com.yy.mediaframework.stat.VideoDataStatistic;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public class BoxReplacer {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !BoxReplacer.class.desiredAssertionStatus();
    }

    public static void replace(Map<String, Box> map, File file) throws IOException {
        IsoFile isoFile = new IsoFile(new FileDataSourceImpl(file), new PropertyBoxParserImpl(new String[0]));
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Box> entry : map.entrySet()) {
            Box path = Path.getPath(isoFile, entry.getKey());
            hashMap.put(Path.createPath(path), entry.getValue());
            if (!$assertionsDisabled && path.getSize() != entry.getValue().getSize()) {
                throw new AssertionError();
            }
        }
        isoFile.close();
        FileChannel channel = new RandomAccessFile(file, VideoDataStatistic.AnchorHiidoCoreStatisticKey.CaptureRealResolutionWidth).getChannel();
        Iterator it = hashMap.entrySet().iterator();
        if (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getKey();
            throw new RuntimeException("ddd");
        }
        channel.close();
    }
}
