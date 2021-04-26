package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.util.Path;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class BoxReplacer {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void replace(Map<String, Box> map, File file) throws IOException {
        IsoFile isoFile = new IsoFile(new FileDataSourceImpl(file), new PropertyBoxParserImpl(new String[0]));
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Box> entry : map.entrySet()) {
            hashMap.put(Path.createPath(Path.getPath(isoFile, entry.getKey())), entry.getValue());
        }
        isoFile.close();
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        Iterator it = hashMap.entrySet().iterator();
        if (!it.hasNext()) {
            channel.close();
        } else {
            String str = (String) ((Map.Entry) it.next()).getKey();
            throw new RuntimeException("ddd");
        }
    }
}
