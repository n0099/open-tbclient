package com.googlecode.mp4parser.authoring.adaptivestreaming;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import com.coremedia.iso.Hex;
import com.coremedia.iso.boxes.SoundMediaHeaderBox;
import com.coremedia.iso.boxes.VideoMediaHeaderBox;
import com.coremedia.iso.boxes.h264.AvcConfigurationBox;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.coremedia.iso.boxes.sampleentry.VisualSampleEntry;
import com.googlecode.mp4parser.Version;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.authoring.builder.FragmentIntersectionFinder;
import com.googlecode.mp4parser.boxes.DTSSpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.googlecode.mp4parser.boxes.mp4.ESDescriptorBox;
import com.googlecode.mp4parser.boxes.mp4.objectdescriptors.AudioSpecificConfig;
import com.kwad.yoga.YogaNodeJNIBase;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import kotlin.jvm.internal.ByteCompanionObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class FlatManifestWriterImpl extends AbstractManifestWriter {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static final Logger LOG;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class DependentSubstreamMask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte dWChannelMaskFirstByte;
        public byte dWChannelMaskSecondByte;
        public EC3SpecificBox.Entry entry;
        public final /* synthetic */ FlatManifestWriterImpl this$0;

        public DependentSubstreamMask(FlatManifestWriterImpl flatManifestWriterImpl, byte b2, byte b3, EC3SpecificBox.Entry entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {flatManifestWriterImpl, Byte.valueOf(b2), Byte.valueOf(b3), entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = flatManifestWriterImpl;
            this.dWChannelMaskFirstByte = b2;
            this.dWChannelMaskSecondByte = b3;
            this.entry = entry;
        }

        public byte getdWChannelMaskFirstByte() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.dWChannelMaskFirstByte : invokeV.byteValue;
        }

        public byte getdWChannelMaskSecondByte() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.dWChannelMaskSecondByte : invokeV.byteValue;
        }

        public DependentSubstreamMask process() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i2 = this.entry.chan_loc;
                if (i2 == 0) {
                    this.dWChannelMaskFirstByte = (byte) (this.dWChannelMaskFirstByte | 3);
                } else if (i2 == 1) {
                    this.dWChannelMaskFirstByte = (byte) (this.dWChannelMaskFirstByte | StandardMessageCodec.LIST);
                } else if (i2 == 2) {
                    this.dWChannelMaskSecondByte = (byte) (this.dWChannelMaskSecondByte | ByteCompanionObject.MIN_VALUE);
                } else if (i2 == 3) {
                    this.dWChannelMaskSecondByte = (byte) (this.dWChannelMaskSecondByte | 8);
                } else if (i2 == 6) {
                    this.dWChannelMaskSecondByte = (byte) (this.dWChannelMaskSecondByte | 5);
                } else if (i2 == 7) {
                    this.dWChannelMaskSecondByte = (byte) (this.dWChannelMaskSecondByte | 2);
                }
                return this;
            }
            return (DependentSubstreamMask) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(598214551, "Lcom/googlecode/mp4parser/authoring/adaptivestreaming/FlatManifestWriterImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(598214551, "Lcom/googlecode/mp4parser/authoring/adaptivestreaming/FlatManifestWriterImpl;");
                return;
            }
        }
        LOG = Logger.getLogger(FlatManifestWriterImpl.class.getName());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlatManifestWriterImpl(FragmentIntersectionFinder fragmentIntersectionFinder) {
        super(fragmentIntersectionFinder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragmentIntersectionFinder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((FragmentIntersectionFinder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private AudioQuality getAacAudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, track, audioSampleEntry)) == null) {
            AudioQuality audioQuality = new AudioQuality();
            AudioSpecificConfig audioSpecificInfo = ((ESDescriptorBox) audioSampleEntry.getBoxes(ESDescriptorBox.class).get(0)).getEsDescriptor().getDecoderConfigDescriptor().getAudioSpecificInfo();
            if (audioSpecificInfo.getSbrPresentFlag() == 1) {
                audioQuality.fourCC = "AACH";
            } else if (audioSpecificInfo.getPsPresentFlag() == 1) {
                audioQuality.fourCC = "AACP";
            } else {
                audioQuality.fourCC = "AACL";
            }
            audioQuality.bitrate = getBitrate(track);
            audioQuality.audioTag = 255;
            audioQuality.samplingRate = audioSampleEntry.getSampleRate();
            audioQuality.channels = audioSampleEntry.getChannelCount();
            audioQuality.bitPerSample = audioSampleEntry.getSampleSize();
            audioQuality.packetSize = 4;
            audioQuality.codecPrivateData = getAudioCodecPrivateData(audioSpecificInfo);
            return audioQuality;
        }
        return (AudioQuality) invokeLL.objValue;
    }

    private String getAudioCodecPrivateData(AudioSpecificConfig audioSpecificConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, audioSpecificConfig)) == null) ? Hex.encodeHex(audioSpecificConfig.getConfigBytes()) : (String) invokeL.objValue;
    }

    private AudioQuality getAudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, track, audioSampleEntry)) == null) {
            if (getFormat(audioSampleEntry).equals(AudioSampleEntry.TYPE3)) {
                return getAacAudioQuality(track, audioSampleEntry);
            }
            if (getFormat(audioSampleEntry).equals(AudioSampleEntry.TYPE9)) {
                return getEc3AudioQuality(track, audioSampleEntry);
            }
            if (getFormat(audioSampleEntry).startsWith("dts")) {
                return getDtsAudioQuality(track, audioSampleEntry);
            }
            throw new InternalError("I don't know what to do with audio of type " + getFormat(audioSampleEntry));
        }
        return (AudioQuality) invokeLL.objValue;
    }

    private byte[] getAvcCodecPrivateData(AvcConfigurationBox avcConfigurationBox) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, avcConfigurationBox)) == null) {
            List<byte[]> sequenceParameterSets = avcConfigurationBox.getSequenceParameterSets();
            List<byte[]> pictureParameterSets = avcConfigurationBox.getPictureParameterSets();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[4];
                bArr[3] = 1;
                byteArrayOutputStream.write(bArr);
                for (byte[] bArr2 : sequenceParameterSets) {
                    byteArrayOutputStream.write(bArr2);
                }
                byte[] bArr3 = new byte[4];
                bArr3[3] = 1;
                byteArrayOutputStream.write(bArr3);
                for (byte[] bArr4 : pictureParameterSets) {
                    byteArrayOutputStream.write(bArr4);
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new RuntimeException("ByteArrayOutputStream do not throw IOException ?!?!?");
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private AudioQuality getDtsAudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, track, audioSampleEntry)) == null) {
            DTSSpecificBox dTSSpecificBox = (DTSSpecificBox) audioSampleEntry.getBoxes(DTSSpecificBox.class).get(0);
            if (dTSSpecificBox != null) {
                ByteBuffer allocate = ByteBuffer.allocate(22);
                int frameDuration = dTSSpecificBox.getFrameDuration();
                int i2 = frameDuration != 0 ? frameDuration != 1 ? frameDuration != 2 ? frameDuration != 3 ? 0 : 4096 : 2048 : 1024 : 512;
                allocate.put((byte) (i2 & 255));
                allocate.put((byte) (i2 >>> 8));
                int i3 = getNumChannelsAndMask(dTSSpecificBox)[1];
                allocate.put((byte) (i3 & 255));
                allocate.put((byte) (i3 >>> 8));
                allocate.put((byte) (i3 >>> 16));
                allocate.put((byte) (i3 >>> 24));
                allocate.put(new byte[]{-82, -28, -65, 94, 97, 94, 65, -121, -110, -4, -92, -127, 38, -103, 2, 17});
                ByteBuffer allocate2 = ByteBuffer.allocate(8);
                allocate2.put((byte) dTSSpecificBox.getStreamConstruction());
                int channelLayout = dTSSpecificBox.getChannelLayout();
                allocate2.put((byte) (channelLayout & 255));
                allocate2.put((byte) (channelLayout >>> 8));
                allocate2.put((byte) (channelLayout >>> 16));
                allocate2.put((byte) (channelLayout >>> 24));
                allocate2.put((byte) (((byte) (dTSSpecificBox.getMultiAssetFlag() << 1)) | dTSSpecificBox.getLBRDurationMod()));
                allocate2.put(new byte[2]);
                AudioQuality audioQuality = new AudioQuality();
                audioQuality.fourCC = getFormat(audioSampleEntry);
                audioQuality.bitrate = dTSSpecificBox.getAvgBitRate();
                audioQuality.audioTag = FragmentActivity.MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
                audioQuality.samplingRate = dTSSpecificBox.getDTSSamplingFrequency();
                audioQuality.channels = getNumChannelsAndMask(dTSSpecificBox)[0];
                audioQuality.bitPerSample = 16;
                audioQuality.packetSize = (int) track.getSamples().get(0).getSize();
                audioQuality.codecPrivateData = String.valueOf(Hex.encodeHex(allocate.array())) + Hex.encodeHex(allocate2.array());
                return audioQuality;
            }
            throw new RuntimeException("DTS track misses DTSSpecificBox!");
        }
        return (AudioQuality) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x019f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x001f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private AudioQuality getEc3AudioQuality(Track track, AudioSampleEntry audioSampleEntry) {
        InterceptResult invokeLL;
        int i2;
        byte b2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, track, audioSampleEntry)) == null) {
            EC3SpecificBox eC3SpecificBox = (EC3SpecificBox) audioSampleEntry.getBoxes(EC3SpecificBox.class).get(0);
            if (eC3SpecificBox != null) {
                byte b3 = 0;
                byte b4 = 0;
                short s = 0;
                short s2 = 0;
                for (EC3SpecificBox.Entry entry : eC3SpecificBox.getEntries()) {
                    switch (entry.acmod) {
                        case 0:
                            throw new RuntimeException("Smooth Streaming doesn't support DDP 1+1 mode");
                        case 1:
                            s = (short) (s + 1);
                            if (entry.num_dep_sub > 0) {
                                DependentSubstreamMask process = new DependentSubstreamMask(this, b3, b4, entry).process();
                                b3 = (byte) (b3 | process.getdWChannelMaskFirstByte());
                                b2 = process.getdWChannelMaskSecondByte();
                                i4 = b4 | b2;
                                b4 = (byte) i4;
                                if (entry.lfeon == 1) {
                                    s2 = (short) (s2 + 1);
                                    b3 = (byte) (b3 | YogaNodeJNIBase.HAS_NEW_LAYOUT);
                                }
                            } else {
                                i2 = b3 | 32;
                                b3 = (byte) i2;
                                if (entry.lfeon == 1) {
                                }
                            }
                        case 2:
                            s = (short) (s + 2);
                            if (entry.num_dep_sub > 0) {
                                DependentSubstreamMask process2 = new DependentSubstreamMask(this, b3, b4, entry).process();
                                b3 = (byte) (b3 | process2.getdWChannelMaskFirstByte());
                                b2 = process2.getdWChannelMaskSecondByte();
                                i4 = b4 | b2;
                                b4 = (byte) i4;
                                if (entry.lfeon == 1) {
                                }
                            } else {
                                i2 = b3 | 192;
                                b3 = (byte) i2;
                                if (entry.lfeon == 1) {
                                }
                            }
                            break;
                        case 3:
                            s = (short) (s + 3);
                            if (entry.num_dep_sub > 0) {
                                DependentSubstreamMask process3 = new DependentSubstreamMask(this, b3, b4, entry).process();
                                b3 = (byte) (b3 | process3.getdWChannelMaskFirstByte());
                                b2 = process3.getdWChannelMaskSecondByte();
                                i4 = b4 | b2;
                                b4 = (byte) i4;
                                if (entry.lfeon == 1) {
                                }
                            } else {
                                i2 = b3 | 224;
                                b3 = (byte) i2;
                                if (entry.lfeon == 1) {
                                }
                            }
                            break;
                        case 4:
                            s = (short) (s + 3);
                            if (entry.num_dep_sub > 0) {
                                DependentSubstreamMask process4 = new DependentSubstreamMask(this, b3, b4, entry).process();
                                b3 = (byte) (b3 | process4.getdWChannelMaskFirstByte());
                                b2 = process4.getdWChannelMaskSecondByte();
                                i4 = b4 | b2;
                                b4 = (byte) i4;
                                if (entry.lfeon == 1) {
                                }
                            } else {
                                i3 = b3 | 192;
                                b3 = (byte) i3;
                                i4 = b4 | ByteCompanionObject.MIN_VALUE;
                                b4 = (byte) i4;
                                if (entry.lfeon == 1) {
                                }
                            }
                            break;
                        case 5:
                            s = (short) (s + 4);
                            if (entry.num_dep_sub > 0) {
                                DependentSubstreamMask process5 = new DependentSubstreamMask(this, b3, b4, entry).process();
                                b3 = (byte) (b3 | process5.getdWChannelMaskFirstByte());
                                b2 = process5.getdWChannelMaskSecondByte();
                                i4 = b4 | b2;
                                b4 = (byte) i4;
                                if (entry.lfeon == 1) {
                                }
                            } else {
                                i3 = b3 | 224;
                                b3 = (byte) i3;
                                i4 = b4 | ByteCompanionObject.MIN_VALUE;
                                b4 = (byte) i4;
                                if (entry.lfeon == 1) {
                                }
                            }
                            break;
                        case 6:
                            s = (short) (s + 4);
                            if (entry.num_dep_sub > 0) {
                                DependentSubstreamMask process6 = new DependentSubstreamMask(this, b3, b4, entry).process();
                                b3 = (byte) (b3 | process6.getdWChannelMaskFirstByte());
                                b2 = process6.getdWChannelMaskSecondByte();
                                i4 = b4 | b2;
                                b4 = (byte) i4;
                                if (entry.lfeon == 1) {
                                }
                            } else {
                                i2 = b3 | 204;
                                b3 = (byte) i2;
                                if (entry.lfeon == 1) {
                                }
                            }
                            break;
                        case 7:
                            s = (short) (s + 5);
                            if (entry.num_dep_sub > 0) {
                                DependentSubstreamMask process7 = new DependentSubstreamMask(this, b3, b4, entry).process();
                                b3 = (byte) (b3 | process7.getdWChannelMaskFirstByte());
                                b2 = process7.getdWChannelMaskSecondByte();
                                i4 = b4 | b2;
                                b4 = (byte) i4;
                                if (entry.lfeon == 1) {
                                }
                            } else {
                                i2 = b3 | 236;
                                b3 = (byte) i2;
                                if (entry.lfeon == 1) {
                                }
                            }
                            break;
                        default:
                            if (entry.lfeon == 1) {
                            }
                            break;
                    }
                }
                ByteBuffer allocate = ByteBuffer.allocate(22);
                allocate.put(new byte[]{0, 6});
                allocate.put(b3);
                allocate.put(b4);
                allocate.put(new byte[2]);
                allocate.put(new byte[]{-81, -121, -5, -89, 2, UtilsBlink.VER_TYPE_SEPARATOR, -5, 66, -92, -44, 5, -51, -109, -124, 59, -35});
                ByteBuffer allocate2 = ByteBuffer.allocate((int) eC3SpecificBox.getContentSize());
                eC3SpecificBox.getContent(allocate2);
                AudioQuality audioQuality = new AudioQuality();
                audioQuality.fourCC = "EC-3";
                audioQuality.bitrate = getBitrate(track);
                audioQuality.audioTag = FragmentActivity.MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
                audioQuality.samplingRate = audioSampleEntry.getSampleRate();
                audioQuality.channels = s + s2;
                audioQuality.bitPerSample = 16;
                audioQuality.packetSize = (int) track.getSamples().get(0).getSize();
                audioQuality.codecPrivateData = String.valueOf(Hex.encodeHex(allocate.array())) + Hex.encodeHex(allocate2.array());
                return audioQuality;
            }
            throw new RuntimeException("EC-3 track misses EC3SpecificBox!");
        }
        return (AudioQuality) invokeLL.objValue;
    }

    private int[] getNumChannelsAndMask(DTSSpecificBox dTSSpecificBox) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, dTSSpecificBox)) == null) {
            int channelLayout = dTSSpecificBox.getChannelLayout();
            if ((channelLayout & 1) == 1) {
                i2 = 1;
                i3 = 4;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if ((channelLayout & 2) == 2) {
                i2 += 2;
                i3 = i3 | 1 | 2;
            }
            if ((channelLayout & 4) == 4) {
                i2 += 2;
                i3 = i3 | 16 | 32;
            }
            if ((channelLayout & 8) == 8) {
                i2++;
                i3 |= 8;
            }
            if ((channelLayout & 16) == 16) {
                i2++;
                i3 |= 256;
            }
            if ((channelLayout & 32) == 32) {
                i2 += 2;
                i3 = i3 | 4096 | 16384;
            }
            if ((channelLayout & 64) == 64) {
                i2 += 2;
                i3 = i3 | 16 | 32;
            }
            if ((channelLayout & 128) == 128) {
                i2++;
                i3 |= 8192;
            }
            if ((channelLayout & 256) == 256) {
                i2++;
                i3 |= 2048;
            }
            if ((channelLayout & 512) == 512) {
                i2 += 2;
                i3 = i3 | 64 | 128;
            }
            if ((channelLayout & 1024) == 1024) {
                i2 += 2;
                i3 = i3 | 512 | 1024;
            }
            if ((channelLayout & 2048) == 2048) {
                i2 += 2;
                i3 = i3 | 16 | 32;
            }
            if ((channelLayout & 4096) == 4096) {
                i2++;
                i3 |= 8;
            }
            if ((channelLayout & 8192) == 8192) {
                i2 += 2;
                i3 = i3 | 16 | 32;
            }
            if ((channelLayout & 16384) == 16384) {
                i2++;
                i3 |= 65536;
            }
            if ((channelLayout & 32768) == 32768) {
                i2 += 2;
                i3 = 32768 | i3 | 131072;
            }
            if ((channelLayout & 65536) == 65536) {
                i2++;
            }
            if ((channelLayout & 131072) == 131072) {
                i2 += 2;
            }
            return new int[]{i2, i3};
        }
        return (int[]) invokeL.objValue;
    }

    private VideoQuality getVideoQuality(Track track, VisualSampleEntry visualSampleEntry) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, track, visualSampleEntry)) == null) {
            if (VisualSampleEntry.TYPE3.equals(getFormat(visualSampleEntry))) {
                AvcConfigurationBox avcConfigurationBox = (AvcConfigurationBox) visualSampleEntry.getBoxes(AvcConfigurationBox.class).get(0);
                VideoQuality videoQuality = new VideoQuality();
                videoQuality.bitrate = getBitrate(track);
                videoQuality.codecPrivateData = Hex.encodeHex(getAvcCodecPrivateData(avcConfigurationBox));
                videoQuality.fourCC = "AVC1";
                videoQuality.width = visualSampleEntry.getWidth();
                videoQuality.height = visualSampleEntry.getHeight();
                videoQuality.nalLength = avcConfigurationBox.getLengthSizeMinusOne() + 1;
                return videoQuality;
            }
            throw new InternalError("I don't know how to handle video of type " + getFormat(visualSampleEntry));
        }
        return (VideoQuality) invokeLL.objValue;
    }

    public Document customizeManifest(Document document) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, document)) == null) ? document : (Document) invokeL.objValue;
    }

    @Override // com.googlecode.mp4parser.authoring.adaptivestreaming.ManifestWriter
    public String getManifest(Movie movie) throws IOException {
        InterceptResult invokeL;
        Element element;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, movie)) == null) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            long j2 = -1;
            long j3 = -1;
            for (Track track : movie.getTracks()) {
                if (track.getMediaHeaderBox() instanceof VideoMediaHeaderBox) {
                    this.videoFragmentsDurations = checkFragmentsAlign(this.videoFragmentsDurations, calculateFragmentDurations(track, movie));
                    linkedList.add(getVideoQuality(track, (VisualSampleEntry) track.getSampleDescriptionBox().getSampleEntry()));
                    if (j2 == -1) {
                        j2 = track.getTrackMetaData().getTimescale();
                    }
                }
                if (track.getMediaHeaderBox() instanceof SoundMediaHeaderBox) {
                    this.audioFragmentsDurations = checkFragmentsAlign(this.audioFragmentsDurations, calculateFragmentDurations(track, movie));
                    linkedList2.add(getAudioQuality(track, (AudioSampleEntry) track.getSampleDescriptionBox().getSampleEntry()));
                    if (j3 == -1) {
                        j3 = track.getTrackMetaData().getTimescale();
                    }
                }
            }
            try {
                Document newDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                Element createElement = newDocument.createElement("SmoothStreamingMedia");
                newDocument.appendChild(createElement);
                createElement.setAttribute("MajorVersion", "2");
                createElement.setAttribute("MinorVersion", "1");
                createElement.setAttribute("Duration", "0");
                createElement.appendChild(newDocument.createComment(Version.VERSION));
                String str8 = "StreamIndex";
                Element createElement2 = newDocument.createElement("StreamIndex");
                String str9 = "Type";
                createElement2.setAttribute("Type", "video");
                String str10 = "TimeScale";
                createElement2.setAttribute("TimeScale", Long.toString(j2));
                String str11 = "Chunks";
                createElement2.setAttribute("Chunks", Integer.toString(this.videoFragmentsDurations.length));
                String str12 = "Url";
                createElement2.setAttribute("Url", "video/{bitrate}/{start time}");
                String str13 = "QualityLevels";
                createElement2.setAttribute("QualityLevels", Integer.toString(linkedList.size()));
                createElement.appendChild(createElement2);
                int i2 = 0;
                while (true) {
                    int size = linkedList.size();
                    LinkedList linkedList3 = linkedList;
                    element = createElement2;
                    str = "CodecPrivateData";
                    str2 = "Bitrate";
                    str3 = "Index";
                    str4 = "FourCC";
                    str5 = "QualityLevel";
                    if (i2 >= size) {
                        break;
                    }
                    String str14 = str9;
                    String str15 = str11;
                    createElement2 = element;
                    linkedList = linkedList3;
                    VideoQuality videoQuality = (VideoQuality) linkedList.get(i2);
                    Element createElement3 = newDocument.createElement("QualityLevel");
                    createElement3.setAttribute("Index", Integer.toString(i2));
                    createElement3.setAttribute(str2, Long.toString(videoQuality.bitrate));
                    createElement3.setAttribute(str4, videoQuality.fourCC);
                    createElement3.setAttribute("MaxWidth", Long.toString(videoQuality.width));
                    createElement3.setAttribute("MaxHeight", Long.toString(videoQuality.height));
                    createElement3.setAttribute(str, videoQuality.codecPrivateData);
                    createElement3.setAttribute("NALUnitLengthField", Integer.toString(videoQuality.nalLength));
                    createElement2.appendChild(createElement3);
                    i2++;
                    str13 = str13;
                    createElement = createElement;
                    str8 = str8;
                    str12 = str12;
                    str10 = str10;
                    str9 = str14;
                    str11 = str15;
                }
                int i3 = 0;
                while (true) {
                    str6 = str3;
                    str7 = str5;
                    if (i3 >= this.videoFragmentsDurations.length) {
                        break;
                    }
                    Element element2 = createElement;
                    Element createElement4 = newDocument.createElement("c");
                    createElement4.setAttribute("n", Integer.toString(i3));
                    createElement4.setAttribute("d", Long.toString(this.videoFragmentsDurations[i3]));
                    element.appendChild(createElement4);
                    i3++;
                    str3 = str6;
                    str5 = str7;
                    str10 = str10;
                    str9 = str9;
                    str11 = str11;
                    str4 = str4;
                    str8 = str8;
                    str = str;
                    createElement = element2;
                    str2 = str2;
                    str12 = str12;
                }
                if (this.audioFragmentsDurations != null) {
                    Element createElement5 = newDocument.createElement(str8);
                    createElement5.setAttribute(str9, MediaStreamTrack.AUDIO_TRACK_KIND);
                    createElement5.setAttribute(str10, Long.toString(j3));
                    createElement5.setAttribute(str11, Integer.toString(this.audioFragmentsDurations.length));
                    createElement5.setAttribute(str12, "audio/{bitrate}/{start time}");
                    createElement5.setAttribute(str13, Integer.toString(linkedList2.size()));
                    createElement.appendChild(createElement5);
                    for (int i4 = 0; i4 < linkedList2.size(); i4++) {
                        AudioQuality audioQuality = (AudioQuality) linkedList2.get(i4);
                        Element createElement6 = newDocument.createElement(str7);
                        createElement6.setAttribute(str6, Integer.toString(i4));
                        createElement6.setAttribute(str4, audioQuality.fourCC);
                        createElement6.setAttribute(str2, Long.toString(audioQuality.bitrate));
                        createElement6.setAttribute("AudioTag", Integer.toString(audioQuality.audioTag));
                        createElement6.setAttribute("SamplingRate", Long.toString(audioQuality.samplingRate));
                        createElement6.setAttribute("Channels", Integer.toString(audioQuality.channels));
                        createElement6.setAttribute("BitsPerSample", Integer.toString(audioQuality.bitPerSample));
                        createElement6.setAttribute("PacketSize", Integer.toString(audioQuality.packetSize));
                        createElement6.setAttribute(str, audioQuality.codecPrivateData);
                        createElement5.appendChild(createElement6);
                    }
                    for (int i5 = 0; i5 < this.audioFragmentsDurations.length; i5++) {
                        Element createElement7 = newDocument.createElement("c");
                        createElement7.setAttribute("n", Integer.toString(i5));
                        createElement7.setAttribute("d", Long.toString(this.audioFragmentsDurations[i5]));
                        createElement5.appendChild(createElement7);
                    }
                }
                newDocument.setXmlStandalone(true);
                DOMSource dOMSource = new DOMSource(customizeManifest(newDocument));
                StringWriter stringWriter = new StringWriter();
                StreamResult streamResult = new StreamResult(stringWriter);
                try {
                    Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                    newTransformer.setOutputProperty("indent", "yes");
                    newTransformer.transform(dOMSource, streamResult);
                    return stringWriter.getBuffer().toString();
                } catch (TransformerConfigurationException e2) {
                    throw new IOException(e2);
                } catch (TransformerException e3) {
                    throw new IOException(e3);
                }
            } catch (ParserConfigurationException e4) {
                throw new IOException(e4);
            }
        }
        return (String) invokeL.objValue;
    }
}
